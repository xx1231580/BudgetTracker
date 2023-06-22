import MusicPlaylistClient from "../api/musicPlaylistClient";
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from "../util/DataStore";

class ViewBudget extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['getBudgetForPage', 'getExpensesForPage', 'mount', 'createBudgetTable',  'createExpensesTable', 'addBudgetToPage', 'addExpensesToPage'], this)
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
        this.dataStore.addChangeListener(this.addBudgetToPage);
        this.dataStore.addChangeListener(this.addExpensesToPage);
    
    }

    async getBudgetForPage() {
        const urlParams = new URLSearchParams(window.location.search);
        const budgetId = urlParams.get('budgetId');
        const budget = await this.client.getBudget(budgetId);
        this.dataStore.set('budget', budget);
        console.log("budget is stored");
    }

    async getExpensesForPage() {
        const urlParams = new URLSearchParams(window.location.search);
        const budgetId = urlParams.get('budgetId');
        const expenses = await this.client.getExpenses(budgetId);
        this.dataStore.set('expenses', expenses);
        console.log("expenses are stored");
        console.log(expenses);
    
    }

    mount() {
        this.header.addHeaderToPage();
        this.client = new MusicPlaylistClient();
        this.getBudgetForPage();
        this.getExpensesForPage();
    }

    createBudgetTable(budget) {
        if (budget.length === 0) {
            return '<h4>No budgets found</h4>';
        }

        let html = `
        <table>
            <tr>
                
                
            </tr>`;
        
        html += `
                <tr>
                    <td>
                        <a href="editBudget.html?budgetId=${budget.budgetId}" class="edit-button">Edit Income</a>
                        <a href="createExpense.html?budgetId=${budget.budgetId}" class="create-button">Create Expense</a>
                        <a href="#" class="delete-button">Delete Budget</a>
                    </td>
                </tr>
            </table>`;

        return html;
    }

    createExpensesTable(expenses) {
        
        const budget = this.dataStore.get('budget');
        console.log(budget);
        var temp = { ...budget}
        let spendingvalue = temp['monthlyIncome'];
        let float = parseFloat(spendingvalue);
        var incomeMoney = document.getElementById("monthly-budget");
                incomeMoney.textContent = "$" + float.toFixed(2); 
        console.log(float);
        if (budget == null) {
            return;
        }

        let html = `
        <form>
            <table>
                <tr>
                    <th>
                    Expense
                    </th>
                    <th>
                    Expense Value
                    </th>
                    <th>
                    Actions
                    </th>
                </tr>`;
        
        for (const expense of expenses) {
            float -= parseFloat(expense.expenseValue);
            html += `
                <tr>
                    <td>
                    ${expense.expenseName}
                    </td>
                    <td>
                    ${expense.expenseValue}
                    </td>
                    <td>
                        <a href="editExpense.html?budgetId=${budget.budgetId}&expenseId=${expense.expenseId}" class="edit-button">Edit Expense</a>
                        <a href="#" class="delete-button">Delete Expense</a>
                    </td>
                </tr>`;
            }
        
                console.log(float)
                var spendingmoney = document.getElementById("spending-budget");
                spendingmoney.textContent = "$" + float.toFixed(2); 
             
        html += `
            </table>
        </form>`;

        return html;
    }

    addBudgetToPage() {
        const budget = this.dataStore.get('budget');
        if (budget == null) {
            return;
        }

        document.getElementById('viewBudgetTable').innerHTML = this.createBudgetTable(budget);
    }

    addExpensesToPage() {
        const expenses = this.dataStore.get('expenses');
        if (expenses == null) {
            return;
        }

        document.getElementById('viewExpensesTable').innerHTML = this.createExpensesTable(expenses);
       // document.getElementById('deleteExpense').addEventListener('click', this.deleteExpense);
    }


//  async deleteExpense(event) {
//         if(confirm("Are you sure you want to delete this expense?")){
//             event.preventDefault();
//             const urlParams = new URLSearchParams(window.location.search);
//             console.log("getting event button", event.target.dataset.expenseid);
//             const budgetId = urlParams.get('budgetId');
//             const expenseId = event.target.dataset.expenseid;
//             await this.client.deleteExpense(budgetId, expenseId);
//             alert(expenseId + " has been deleted.");
//             location.reload();
//         }
        
//     }
}

const main = async () => {
    const viewBudget = new ViewBudget();
    viewBudget.mount();
};

window.addEventListener('DOMContentLoaded', main);