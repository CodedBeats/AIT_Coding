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
    }
}
