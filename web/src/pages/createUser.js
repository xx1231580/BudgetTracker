// import MusicPlaylistClient from '../api/musicPlaylistClient';
// import Header from '../components/header';
// import BindingClass from '../util/bindingClass';
// import DataStore from '../util/DataStore';

// export default class CreateUser extends BindingClass {
//     constructor() {
//         super();
//         this.bindClassMethods(['mount', 'submit', 'redirectToViewBudget'], this);
//         this.dataStore = new DataStore();
//         this.dataStore.addChangeListener(this.redirectToViewBudget);
//         this.header = new Header(this.dataStore);
//     }

//     mount() {
//         this.submit();

//         this.header.addHeaderToPage();

//         this.client = new MusicPlaylistClient();
//     }

//     async submit() {
        

        

//         //const budgetTitle = document.getElementById('budget-title').value;
        

//         const userId = " ";
        
//         const urlParams = new URLSearchParams(window.location.search);
//         const budgetId = " ";

        
//         const user  = await this.client.createUser(userId, budgetId, (error) => {
//             errorMessageDisplay.innerText = `Error: ${error.message}`;
//             errorMessageDisplay.classList.remove('hidden');
//         });

//         console.log('done');
//         this.dataStore.set('user', user);
//     }

//     redirectToViewBudget() {
//         const budget = this.dataStore.get('budget');
//         if (budget != null) {
//             window.location.href = `/index.html?budgetId=${budget.budgetId}`;
//         }
//     }
// }

// const main = async () => {
//     const createUser = new CreateUser();
//     createUser.mount();
// };

// window.addEventListener('DOMContentLoaded', main);
