package BudgetTracker.converters;

import java.util.ArrayList;
import java.util.List;

import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.dynamodb.models.Expense;
import BudgetTracker.dynamodb.models.User;
import BudgetTracker.models.BudgetModel;
import BudgetTracker.models.ExpenseModel;
import BudgetTracker.models.UserModel;

public class ModelConverter {
    public BudgetModel toBudgetModel(Budget budget) {
        return BudgetModel.builder()
            .withBudgetId(budget.getBudgetId())
            .withMonthlyIncome(budget.getMonthlyIncome())
            .withExpenses(budget.getSerializedExpenses())
            .build();
    }

    public ExpenseModel toExpenseModel(Expense expense) {
       return ExpenseModel.builder()
           .withBudgetId(expense.getBudgetId())
           .withExpenseName(expense.getExpenseName())
           .withExpenseValue(expense.getExpenseValue())
           .withExpenseId(expense.getExpenseId())
           .build();
    }

    public List<ExpenseModel> toListOfExpenseModels(List<Expense> expenseList) {
        List<ExpenseModel> expenseModels = new ArrayList<>();

        for (Expense expense : expenseList) {
            expenseModels.add(toExpenseModel(expense));
        }

        return expenseModels;
    }

    public UserModel toUserModel(User user) {
        return UserModel.builder()
            .withBudgetId(user.getBudgetId())
            .withUserId(user.getUserId())
            .build();
    }
}
