import MusicPlaylistClient from '../api/musicPlaylistClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view playlist page of the website.
 */
class LoadExpenses extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'addExpensesToPage', 'createTable'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.addExpensesToPage);
        this.header = new Header(this.dataStore);
        console.log("load-ticket constructor");
    }

    createTable(expenses){
        if (expenses.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>Project Title</th><th>Status</th><th>Actions</th></tr>';
        for (const res of expenses) {
            html += `
            <tr>
                <td>
                    <a href=viewBudget.html?budgetId=${res.budgetId}>${res.title}</a>
                </td>
                <td>
                    ${res.status}
                </td>
                <td><a href="viewBudget.html?projectId=${res.budgetId}" class="view-button">View Project</a>
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
        const expenses = await this.client.getExpenses();
        this.dataStore.set('expenses', expenses);
        //document.getElementById('tickets').innerText = "(loading tickets...)";
        //const tickets = await this.client.getProjectTickets(projectId);
        //this.dataStore.set('tickets', tickets);
        console.log("expenses", expenses);
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
    addExpensesToPage() {
        const expenses = this.dataStore.get('expenses');
        if (expenses == null) {
            return;
        }

        //document.getElementById('project-title').innerText = project.title;
        //document.getElementById('project-description').innerText = project.description;

        let ticketHtml = '';
        let expenseId;
        for (expenseId of expenses) {
            ticketHtml += '<div class="expenses">' + expenseId + '</div>';
        }

        document.getElementById('expenses').innerHTML = this.createTable(expenses);
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const loadExpenses = new LoadExpenses();
    loadExpenses.mount();
};

window.addEventListener('DOMContentLoaded', main);