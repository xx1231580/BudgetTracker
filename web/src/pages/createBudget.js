import MusicPlaylistClient from '../api/musicPlaylistClient';
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

class CreateBudget extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewBudget'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToViewBudget);
        this.header = new Header(this.dataStore);
    }

    mount() {
        document.getElementById('create').addEventListener('click', this.submit);

        this.header.addHeaderToPage();

        this.client = new MusicPlaylistClient();
    }

    async submit(evt) {
        evt.preventDefault();
        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const createButton = document.getElementById('create');
        const origButtonText = createButton.innerText;
        createButton.innerText = 'Loading...';


        //const budgetTitle = document.getElementById('budget-title').value;
        const monthlyIncome = document.getElementById('monthly-income').value;

        const budget = await this.client.createBudget(monthlyIncome, (error) => {
            createButton.innerText = origButtonText;
            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');
        });

        console.log('done');
        this.dataStore.set('budget', budget);
    }

    redirectToViewBudget() {
        const budget = this.dataStore.get('budget');
        if (budget != null) {
            window.location.href = `/index.html?budgetId=${budget.budgetId}`;
        }
    }
}

const main = async () => {
    const createBudget = new CreateBudget();
    createBudget.mount();
};

window.addEventListener('DOMContentLoaded', main);
