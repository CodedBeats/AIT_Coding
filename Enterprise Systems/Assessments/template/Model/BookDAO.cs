using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model.DataSetBookTableAdapters;
using static Model.DataSetUser;
using System.Data;

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


        // Book Name
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
    }
}
