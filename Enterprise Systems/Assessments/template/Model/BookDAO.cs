using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model.DataSetBookTableAdapters;
using static Model.DataSetUser;
using System.Data;
using Model.DataSetUserTableAdapters;
using System.Security.Cryptography;
using System.Security.Policy;

namespace Model
{
    public class BookDAO
    {
        // Books
        public List<Book> GetAllBooks()
        {
            // connect to the db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query and store data in object
            DataSetBook.TabBookDataTable tabBookDataTable = tabBookTableAdapter.GetAllBooks();

            // check if there isn't data
            int dataCount = tabBookDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<Book> books = new List<Book>();

                // iterate through data storing each row in a new user
                foreach (DataRow row in tabBookDataTable)
                {
                    // store user data in correct format in variables
                    string isbn = row["ISBN"].ToString();
                    string bookName = row["BookName"].ToString();
                    int author = Convert.ToInt32(row["Author"]);
                    int category = Convert.ToInt32(row["Category"]);
                    int language = Convert.ToInt32(row["Language"]);
                    int publishYear = Convert.ToInt32(row["PublishYear"]);
                    string publisher = row["Publisher"].ToString();
                    int pages = Convert.ToInt32(row["Pages"]);

                    // set user data with created variables
                    Book book = new Book();
                    book.ISBN = isbn;
                    book.BookName = bookName;
                    book.Author = author;
                    book.Category = category;
                    book.Language = language;
                    book.PublishYear = publishYear;
                    book.Publisher = publisher;
                    book.Pages = pages;

                    // add user to list
                    books.Add(book);
                }

                return books;
            }
        }


        // Book Name but fancy
        public List<Book> FindBookByName(string searchInput)
        {
            // connect to the db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query and store data in object
            DataSetBook.TabBookDataTable tabBookDataTable = tabBookTableAdapter.FindBookByName(searchInput);

            // check if there isn't data
            int dataCount = tabBookDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<Book> books = new List<Book>();

                // iterate through data storing each row in a new user
                foreach (DataRow row in tabBookDataTable)
                {
                    // store user data in correct format in variables
                    string isbn = row["ISBN"].ToString();
                    string bookName = row["BookName"].ToString();
                    int author = Convert.ToInt32(row["Author"]);
                    int category = Convert.ToInt32(row["Category"]);
                    int language = Convert.ToInt32(row["Language"]);
                    int publishYear = Convert.ToInt32(row["PublishYear"]);
                    string publisher = row["Publisher"].ToString();
                    int pages = Convert.ToInt32(row["Pages"]);

                    // set user data with created variables
                    Book book = new Book();
                    book.ISBN = isbn;
                    book.BookName = bookName;
                    book.Author = author;
                    book.Category = category;
                    book.Language = language;
                    book.PublishYear = publishYear;
                    book.Publisher = publisher;
                    book.Pages = pages;

                    // add user to list
                    books.Add(book);
                }

                return books;
            }
        }


        // BookID from Name
        public string FindBookIDByName(string bookName)
        {
            // connect to the db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query
            DataSetBook.TabBookDataTable tabBookDataTable = tabBookTableAdapter.FindBookIDByName(bookName);

            // init UID
            string ISBN = "";

            // check if there isn't data
            int dataCount = tabBookDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return "n/a";
            }
            else
            {
                // iterate through data storing each row in a new book (should only be 1)
                foreach (DataRow row in tabBookDataTable)
                {
                    // store user data in correct format in variable
                    ISBN = row["ISBN"].ToString();
                }

                return ISBN;
            }
        }


        // Book Author
        public List<Book> FindBookByAuthorID(string searchInput)
        {
            // connect to author db and execute query with searchInput to get author id
            AuthorDAO authorDAO = new AuthorDAO();
            int authorID = authorDAO.FindAuthorByName(searchInput);

            // connect to book db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query and store data in object
            DataSetBook.TabBookDataTable tabBookDataTable = tabBookTableAdapter.FindBookByAuthorID(authorID);

            // check if there isn't data
            int dataCount = tabBookDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<Book> books = new List<Book>();

                // iterate through data storing each row in a new user
                foreach (DataRow row in tabBookDataTable)
                {
                    // store user data in correct format in variables
                    string isbn = row["ISBN"].ToString();
                    string bookName = row["BookName"].ToString();
                    int author = Convert.ToInt32(row["Author"]);
                    int category = Convert.ToInt32(row["Category"]);
                    int language = Convert.ToInt32(row["Language"]);
                    int publishYear = Convert.ToInt32(row["PublishYear"]);
                    string publisher = row["Publisher"].ToString();
                    int pages = Convert.ToInt32(row["Pages"]);

                    // set user data with created variables
                    Book book = new Book();
                    book.ISBN = isbn;
                    book.BookName = bookName;
                    book.Author = author;
                    book.Category = category;
                    book.Language = language;
                    book.PublishYear = publishYear;
                    book.Publisher = publisher;
                    book.Pages = pages;

                    // add user to list
                    books.Add(book);
                }

                return books;
            }
        }


        // Book Category
        public List<Book> FindBookByCategoryID(string searchInput)
        {
            // connect to category db and execute query with searchInput to get category id
            CategoryDAO categoryDAO = new CategoryDAO();
            int authorID = categoryDAO.FindCategoryByName(searchInput);

            // connect to book db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query and store data in object
            DataSetBook.TabBookDataTable tabBookDataTable = tabBookTableAdapter.FindBookByCategoryID(authorID);
            
            // check if there isn't data
            int dataCount = tabBookDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<Book> books = new List<Book>();

                // iterate through data storing each row in a new user
                foreach (DataRow row in tabBookDataTable)
                {
                    // store user data in correct format in variables
                    string isbn = row["ISBN"].ToString();
                    string bookName = row["BookName"].ToString();
                    int author = Convert.ToInt32(row["Author"]);
                    int category = Convert.ToInt32(row["Category"]);
                    int language = Convert.ToInt32(row["Language"]);
                    int publishYear = Convert.ToInt32(row["PublishYear"]);
                    string publisher = row["Publisher"].ToString();
                    int pages = Convert.ToInt32(row["Pages"]);

                    // set user data with created variables
                    Book book = new Book();
                    book.ISBN = isbn;
                    book.BookName = bookName;
                    book.Author = author;
                    book.Category = category;
                    book.Language = language;
                    book.PublishYear = publishYear;
                    book.Publisher = publisher;
                    book.Pages = pages;

                    // add user to list
                    books.Add(book);
                }

                return books;
            }
        }


        // CRUD
        public void CreateBook(string bookName, int publishYear, int pages, string publisher)
        {
            // connect to book db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();

            // ASSUMPTION: Since Book doesn't have an ID, ISBN and foreign keys will be set at random
            // set ISBN
            Random random = new Random();
            long randomNumber = (long)(random.NextDouble() * (9999999999999 - 1000000000000) + 1000000000000);
            string randomISBN = randomNumber.ToString();

            // set author (random num between 1 and 2)
            Random random2 = new Random();
            int randomNumber2 = random2.Next(1, 4);

            // set category (random num between 1 and 2)
            Random random3 = new Random();
            int randomNumber3 = random3.Next(1, 4);

            // set language (random num between 1 and 2)
            Random random4 = new Random();
            int randomNumber4 = random4.Next(1, 4);

            // execute query
            tabBookTableAdapter.CreateBook(randomISBN, bookName, randomNumber2, randomNumber3, randomNumber4, publishYear, pages, publisher);
        }

        public void UpdateBook(string bookName, string originalBookName)
        {
            // connect to book db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query
            tabBookTableAdapter.UpdateBook(bookName, originalBookName);
        }

        public void DeleteBook(string bookName)
        {
            // connect to book db
            TabBookTableAdapter tabBookTableAdapter = new TabBookTableAdapter();
            // execute query
            tabBookTableAdapter.DeleteBook(bookName);
        }
    }
}
