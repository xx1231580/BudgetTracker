import MusicPlaylistClient from '../api/musicPlaylistClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";


class LoadBudgets extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'addBudgetsToPage', 'createTable'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.addBudgetsToPage);
        this.header = new Header(this.dataStore);
    }

    createTable(budgets){
        if (budgets.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>Budget</th><th>Status</th><th>Actions</th></tr>';
        for (const res of budgets) {
            html += `
            <tr>
                <td>
                    <a href=viewBudget.html?budgetId=${res.budgetId}> budget </a>
                </td>
                <td>
                    ${res.status}
                </td>
                <td><a href="viewBudget.html?budgetId=${res.budgetId}" class="view-button">View Budget</a>
            </tr>`;
        }
        html += '</table>';

        return html;
    }

    
    async clientLoaded() {
      
        const budgets = await this.client.getAllBudgets();
        this.dataStore.set('budgets', budgets);
        
        console.log("budgets", budgets);
    }

  
    mount() {
       
        this.header.addHeaderToPage();

        this.client = new MusicPlaylistClient();
        this.clientLoaded();
    }

   
    addBudgetsToPage() {
        const budgets = this.dataStore.get('budgets');
        if (budgets == null) {
            return;
        }

        

        let expenseHtml = '';
        let budgetId;
        for (budgetId of budgets) {
            expenseHtml += '<div class="budgets">' + budgetId + '</div>';
        }

        document.getElementById('budgets').innerHTML = this.createTable(budgets);
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const loadBudgets = new LoadBudgets();
    loadBudgets.mount();
};

window.addEventListener('DOMContentLoaded', main);