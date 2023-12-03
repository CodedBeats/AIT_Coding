using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class AuthorLogic
    {
        public List<Author> GetAllAuthors()
        {
            AuthorDAO authorDAO = new AuthorDAO();
            // create list of authors
            List<Author> authors = authorDAO.GetAllAuthors();

            return authors;
        }


        // CRUD
        public void CreateAuthor(string authorName)
        {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.CreateAuthor(authorName);
        }


        public void UpdateAuthor(string authorName, int authorID)
        {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.UpdateAuthor(authorName, authorID);
        }


        public void DeleteAuthor(int authorID)
        {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.DeleteAuthor(authorID);
        }
    }
}
