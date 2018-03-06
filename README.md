# JavaFX-MySQL CRUD

CRUD app made with JavaFX and MySQL database.

## Samples

### Reading data from database

![crud_1](https://user-images.githubusercontent.com/26482766/37049278-b46c244e-2170-11e8-9eb7-a753b7ba103e.png)

This two books were loaded from MySQL database. On the first attempt to load data and display them in TableView 
I used ArrayList but there were a lot of problems so I find solution by using ObservableList. Now it's working 
but I need to learn more about this List.

### Insert button

![crud_2](https://user-images.githubusercontent.com/26482766/37049695-fb8d4f50-2171-11e8-8270-b2e73e91126b.png)

To insert our new book in database we simply create sql query:

![insert](https://user-images.githubusercontent.com/26482766/37050016-09b57552-2173-11e8-8dce-b5e31636180b.PNG)
                 
We load our ID, Title, Author, year and Pages from TextFields.

Then we execute our query.

### Update button

![crud_3](https://user-images.githubusercontent.com/26482766/37050191-7fa2ceea-2173-11e8-9493-e39c5f08cc24.png)

All we need is ID of book that we want to update.

### Delete button

![crud_4](https://user-images.githubusercontent.com/26482766/37050260-b4703180-2173-11e8-8e78-3f6bd8bc9097.png)

Also all we need to delete our book is ID.

### MySQL Database

![database](https://user-images.githubusercontent.com/26482766/37050437-2ecf0456-2174-11e8-8e6d-372429b9293f.png)


