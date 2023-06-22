//     import Authenticator from "../api/authenticator.js";
//     import CreateUser from "../pages/createUser.js"
//     import axios from "axios";
//     import BindingClass from "../util/bindingClass";

//     let scriptExecuted = false;
//     let secondScript = false;
//     const authenticator = new Authenticator();

//     class GenerateUser extends BindingClass {
//         constructor() {
//             super();
//             this.bindClassMethods(['clientLoaded', 'mount', 'addExpensesToPage', 'createTable'], this);
//             this.dataStore = new DataStore();
//             this.dataStore.addChangeListener(this.addExpensesToPage);
//             this.header = new Header(this.dataStore);
            
//         }
    


//    async clientLoaded() {

//         if (!scriptExecuted && authenticator.isUserLoggedIn()) {
      
//           scriptExecuted = true;
      
//           window.location.href = "createBudget.html";
          
         
//           }
      
//           const urlParams = new URLSearchParams(window.location.search);
      
      
//         if (!secondScript &&urlParams.has('budgetId')) {
//           const createUser = new CreateUser();
//           createUser.main();
//           secondScript = true;
//         }
//       }

//       mount() {
//         this.header.addHeaderToPage();

//         this.client = new MusicPlaylistClient();
//         this.clientLoaded();
//     }

//     }

//     const main = async () => {
//         const generateUser = new GenerateUser();
//         generateUser.mount();
//     };
    
//     window.addEventListener('DOMContentLoaded', main);
