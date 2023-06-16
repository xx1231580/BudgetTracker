
import BindingClass from "../util/bindingClass";
/**
 * The header component for the website.
 */
export default class Header extends BindingClass {
    constructor() {
        super();

        const methodsToBind = [
            'addHeaderToPage', 'createSiteTitle', 'createUserInfoForHeader',
            'createLoginButton', 'createLoginButton', 'createLogoutButton'
        ];
        this.bindClassMethods(methodsToBind, this);

        this.client = new TicketTrackerClient();
    }

    /**
     * Add the header to the page.
     */
    async addHeaderToPage() {
        const currentUser = await this.client.getIdentity();

        const siteTitle = this.createSiteTitle();
        const userInfo = this.createUserInfoForHeader(currentUser);

        const header = document.getElementById('header');
        const navbar = document.createElement('ul');
        const titleItem = document.createElement('li');
//        const title = document.createElement('li');
//        title.classList.add("title-banner");
//        title.innerText = "Project Management System";
        const userItem = document.createElement('li');
        header.appendChild(navbar);

        navbar.appendChild(titleItem);

        navbar.appendChild(userItem);
        titleItem.appendChild(siteTitle);
//         navbar.appendChild(title);
        userItem.appendChild(userInfo);
    }

    createSiteTitle() {
        const homeButton = document.createElement('a');
        homeButton.classList.add('button');
        homeButton.href = 'index.html';
        homeButton.innerText = 'Home';

        const siteTitle = document.createElement('div');
        siteTitle.classList.add('site-title');
        siteTitle.appendChild(homeButton);

        return siteTitle;
    }

    createUserInfoForHeader(currentUser) {
        const userInfo = document.createElement('div');
        userInfo.classList.add('userInfo');

        const childContent = currentUser
            ? this.createLogoutButton(currentUser)
            : this.createLoginButton();

        userInfo.appendChild(childContent);

        return userInfo;
    }

    createLoginButton() {
        return this.createButton('Login', this.client.login);
    }

    createLogoutButton(currentUser) {
        return this.createButton(`Logout: ${currentUser.name}`, this.client.logout);
    }

    createButton(text, clickHandler) {
        const button = document.createElement('a');
        button.classList.add('button');
        button.href = '#';
        button.innerText = text;

        button.addEventListener('click', async () => {
            await clickHandler();
        });

        return button;
    }
}