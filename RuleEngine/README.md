## Rule Engine - Rippling Interview

### Input Format ->

1. List of expenses - `expense_id` , `trip_id` , `amount_usd` , `expense_type` like restaurant, airfare, entertainment, `vendor_type` , `vendor_name`.
2. List of rules - Expense level and Trip level.

### Rules ->

1. No restaurant expense can exceed $75.
2. No airfare expenses are allowed.
3. No entertainment expenses are allowed.
4. No single expense can exceed $250.
5. A trip cannot exceed $2000 in total expenses.
6. Total meal (restaurant) expenses per trip cannot exceed $1000.

### Return Type ->

1. For each expense, return whether APPROVED or REJECTED with reason.
2. For each trip, return whether OK or VIOLATIONS with reason.

