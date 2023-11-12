using DTO;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class BookController
    {
        public List<BookDTO> GetAllBooks()
        {
            BookLogic bookLogic = new BookLogic();
            return bookLogic.GetAllBooks();
        }

        public List<BookDTO> Search(string searchInput, int searchCat)
        {
            BookLogic bookLogic = new BookLogic();

            // search by book name
            if (searchCat == 1)
            {
                return bookLogic.FindBookByName(searchInput);
            }
            // search by author
            else if (searchCat == 2)
            {
                return bookLogic.FindBookByAuthor(searchInput);
            }
            // search by category
            else
            {
                return bookLogic.FindBookByCategory(searchInput);
            }
        }


        // CRUD
        public void CreateBook(string bookName, int publishYear, int pages, string publisher)
        {
            BookLogic bookLogic = new BookLogic();
            bookLogic.CreateBook(bookName, publishYear, pages, publisher);
        }

        public void UpdateBook(string bookName, string originalBookName)
        {
            BookLogic bookLogic = new BookLogic();
            bookLogic.UpdateBook(bookName, originalBookName);
        }

        public void DeleteBook(string bookName)
        {
            BookLogic bookLogic = new BookLogic();
            bookLogic.DeleteBook(bookName);
        }
    }
}
