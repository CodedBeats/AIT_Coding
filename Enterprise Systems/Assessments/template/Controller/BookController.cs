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
    }
}
