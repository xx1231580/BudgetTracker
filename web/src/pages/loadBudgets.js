import MusicPlaylistClient from '../api/musicPlaylistClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view playlist page of the website.
 */
class LoadBudgets extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'addBudgetsToPage', 'createTable'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.addBudgetsToPage);
        //this.dataStore.addChangeListener(this.addExpensesToPage);
        this.header = new Header(this.dataStore);
    }

    createTable(budgets){
        if (budgets.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>Project Title</th><th>Status</th><th>Actions</th></tr>';
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

    /**
     * Once the client is loaded, get the playlist metadata and song list.
     */
    async clientLoaded() {
        //const projectId = urlParams.get('projectId');
        //document.getElementById('project-title').innerText = "Loading Project ...";
        const budgets = await this.client.getAllBudgets();
        this.dataStore.set('budgets', budgets);
        //document.getElementById('tickets').innerText = "(loading tickets...)";
        //const tickets = await this.client.getProjectTickets(projectId);
        //this.dataStore.set('tickets', tickets);
        console.log("budgets", budgets);
    }

    /**
     * Add the header to the page and load the TicketTrackerClient.
     */
    mount() {
        //document.getElementById('add-ticket').addEventListener('click', this.addTicket);
        this.header.addHeaderToPage();

        this.client = new MusicPlaylistClient();
        this.clientLoaded();
    }

    /**
     * When the playlist is updated in the datastore, update the playlist metadata on the page.
     */
    addBudgetsToPage() {
        const budgets = this.dataStore.get('budgets');
        if (budgets == null) {
            return;
        }

        //document.getElementById('project-title').innerText = project.title;
        //document.getElementById('project-description').innerText = project.description;

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