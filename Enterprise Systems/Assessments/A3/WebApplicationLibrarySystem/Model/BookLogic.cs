using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class BookLogic
    {
        public List<Book> GetAllBooks()
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.GetAllBooks();

            return books;
        }

        // search
        public List<Book> FindBookByName(string searchInput)
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.FindBookByName(searchInput);

            return books;
        }

        public List<Book> FindBookByAuthor(string searchInput)
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.FindBookByAuthorID(searchInput);

            return books;
        }

        public List<Book> FindBookByCategory(string searchInput)
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.FindBookByCategoryID(searchInput);

            return books;
        }
    }
}
