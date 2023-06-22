
import axios from "axios";
import BindingClass from "../util/bindingClass";
import Authenticator from "./authenticator";


export default class Header extends BindingClass {
    constructor(props = {}) {
        super();

        const methodsToBind = ['clientLoaded', 'getIdentity', 'login', 'logout', 'createExpense', 'getExpenses', 'createBudget'];
        this.bindClassMethods(methodsToBind, this);

        this.authenticator = new Authenticator();;
        this.props = props;

        axios.defaults.baseURL = process.env.API_BASE_URL;
        this.axiosClient = axios;
        this.clientLoaded();
    }


    clientLoaded() {
        if (this.props.hasOwnProperty("onReady")) {
            this.props.onReady(this);
        }
    }

    async getIdentity(errorCallback) {
        try {
            const isLoggedIn = await this.authenticator.isUserLoggedIn();

            if (!isLoggedIn) {
                return undefined;
            }

            return await this.authenticator.getCurrentUserInfo();
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async login() {
        this.authenticator.login();
    }

    async logout() {
        this.authenticator.logout();
    }

    async getTokenOrThrow(unauthenticatedErrorMessage) {
        const isLoggedIn = await this.authenticator.isUserLoggedIn();
        if (!isLoggedIn) {
            throw new Error(unauthenticatedErrorMessage);
        }

        return await this.authenticator.getUserToken();
    }

    async getAllBudgets(errorCallback) {
        try {
            const response = await this.axiosClient.get(`/budget`);
            return response.data.budgetList;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async getBudget(budgetId, errorCallback) {
        try {
            const response = await this.axiosClient.get(`budget/${budgetId}`);
            return response.data.budget;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async getExpenses(budgetId, errorCallback) {
        try {
            const response = await this.axiosClient.get(`/budget/${budgetId}/expense`);
            return response.data.expenseList;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async createBudget(monthlyIncome, errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can create a budget.");
            const response = await this.axiosClient.post(`budget`, {
                monthlyIncome: monthlyIncome
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data.budget;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async createExpense(expenseName, expenseValue, budgetId, errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can create a budget.");
            const response = await this.axiosClient.post(`expense`, {
                budgetId: budgetId,
                expenseValue: expenseValue,
                expenseName: expenseName
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data.expense;
        } catch (error) {
            console.log(error);
            this.handleError(error, errorCallback)
        }
    }



    /**
     * Add the header to the page.
     */
    async addHeaderToPage() {
        const currentUser = await this.client.getIdentity();

        const siteTitle = this.createSiteTitle();
        const userInfo = this.createUserInfoForHeader(currentUser);

        const header = document.getElementById('header');
        header.appendChild(siteTitle);
        header.appendChild(userInfo);
    }

    createSiteTitle() {
        const homeButton = document.createElement('a');
        homeButton.classList.add('header_home');
        homeButton.href = 'index.html';
        homeButton.innerText = 'Playlists';

        const siteTitle = document.createElement('div');
        siteTitle.classList.add('site-title');
        siteTitle.appendChild(homeButton);

        return siteTitle;
    }

    createUserInfoForHeader(currentUser) {
        const userInfo = document.createElement('div');
        userInfo.classList.add('user');

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

    handleError(error, errorCallback) {
        // console.log(error);
        // console.error(error);
        console.trace(error);

        const errorFromApi = error?.response?.data?.error_message;
        if (errorFromApi) {
            console.error(errorFromApi)
            error.message = errorFromApi;
        }

        if (errorCallback) {
            errorCallback(error);
        }
    }
}