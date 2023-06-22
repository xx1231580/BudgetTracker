import MusicPlaylistClient from '../api/musicPlaylistClient.js';
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';


class CreateExpense extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewProject'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToViewProject);
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

        const expenseTitle = document.getElementById('expense-title').value;
       
        const expenseCost = document.getElementById('expense-cost').value;
       

        const expense = await this.client.createExpense(expenseTitle, expenseCost, (error) => {
            createButton.innerText = origButtonText;
            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');
        });
        this.dataStore.set('expense', expense);
        console.log("hello");
    }

    
    redirectToViewProject() {
        const expense = this.dataStore.get('expense');
        if (expense != null) {
            window.location.href = `index.html`;
        }
    }
}


const main = async () => {
    const createExpense = new CreateExpense();
    createExpense.mount();
};

window.addEventListener('DOMContentLoaded', main);