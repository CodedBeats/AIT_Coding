using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class BookLogic
    {
        // Books
        public List<BookDTO> GetAllBooks()
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.GetAllBooks();

            // check if no books
            if (books == null)
            {
                return null;
            }

            // clone books' data into BookDTO type books
            List<BookDTO> bookDTOs = books.Select(book => new BookDTO
            {
                ISBN = book.ISBN,
                BookName = book.BookName,
                Author = book.Author,
                Category = book.Category,
                Language = book.Language,
                PublishYear = book.PublishYear,
                Publisher = book.Publisher,
                Pages = book.Pages
            }).ToList();

            return bookDTOs;
        }

        // Book Name
        public List<BookDTO> FindBookByName(string searchInput)
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.FindBookByName(searchInput);

            // check if no books
            if (books == null)
            {
                return null;
            }

            // clone books' data into BookDTO type books
            List<BookDTO> bookDTOs = books.Select(book => new BookDTO
            {
                ISBN = book.ISBN,
                BookName = book.BookName,
                Author = book.Author,
                Category = book.Category,
                Language = book.Language,
                PublishYear = book.PublishYear,
                Publisher = book.Publisher,
                Pages = book.Pages
            }).ToList();

            return bookDTOs;
        }

        // Book Author
        public List<BookDTO> FindBookByAuthor(string searchInput)
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.FindBookByAuthorID(searchInput);

            // check if no books
            if (books == null)
            {
                return null;
            }

            // clone books' data into BookDTO type books
            List<BookDTO> bookDTOs = books.Select(book => new BookDTO
            {
                ISBN = book.ISBN,
                BookName = book.BookName,
                Author = book.Author,
                Category = book.Category,
                Language = book.Language,
                PublishYear = book.PublishYear,
                Publisher = book.Publisher,
                Pages = book.Pages
            }).ToList();

            return bookDTOs;
        }

        // Book Category
        public List<BookDTO> FindBookByCategory(string searchInput)
        {
            BookDAO bookDAO = new BookDAO();
            // create list of books
            List<Book> books = bookDAO.FindBookByCategoryID(searchInput);

            // check if no books
            if (books == null)
            {
                return null;
            }

            // clone books' data into BookDTO type books
            List<BookDTO> bookDTOs = books.Select(book => new BookDTO
            {
                ISBN = book.ISBN,
                BookName = book.BookName,
                Author = book.Author,
                Category = book.Category,
                Language = book.Language,
                PublishYear = book.PublishYear,
                Publisher = book.Publisher,
                Pages = book.Pages
            }).ToList();

            return bookDTOs;
        }


        // CRUD
        public void CreateBook(string bookName, int publishYear, int pages, string publisher)
        {
            BookDAO bookDAO = new BookDAO();
            bookDAO.CreateBook(bookName, publishYear, pages, publisher);
        }

        public void UpdateBook(string bookName, string originalBookName)
        {
            BookDAO bookDAO = new BookDAO();
            bookDAO.UpdateBook(bookName, originalBookName);
        }

        public void DeleteBook(string bookName)
        {
            BookDAO bookDAO = new BookDAO();
            bookDAO.DeleteBook(bookName);
        }
    }
}
