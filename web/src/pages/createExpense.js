import MusicPlaylistClient from '../api/musicPlaylistClient.js';
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';


class CreateExpense extends BindingClass {
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

        const expenseName = document.getElementById('expense-title').value;

        console.log(expenseName);
       
        const expenseValue = document.getElementById('expense-cost').value;

        console.log(expenseValue);

        const urlParams = new URLSearchParams(window.location.search);
        const budgetId = urlParams.get('budgetId');

        console.log(budgetId);
       

        const expense = await this.client.createExpense(expenseName, expenseValue, budgetId, (error) => {
            createButton.innerText = origButtonText;
            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');
        });
        this.dataStore.set('expense', expense);
        console.log("hello");
    }

    
    redirectToViewBudget() {
        const expense = this.dataStore.get('expense');
        if (expense != null) {
            window.location.href = `/viewBudget.html?budgetId=${budget.budgetId}`;
        }
    }
}


const main = async () => {
    const createExpense = new CreateExpense();
    createExpense.mount();
};

window.addEventListener('DOMContentLoaded', main);