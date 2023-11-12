using DTO;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class AuthorController
    {
        public List<AuthorDTO> GetAllAuthors()
        {
            AuthorLogic authorLogic = new AuthorLogic();
            return authorLogic.GetAllAuthors();
        }

        public void CreateAuthor(string authorName)
        {
            AuthorLogic authorLogic = new AuthorLogic();
            authorLogic.CreateAuthor(authorName);
        }


        public void UpdateAuthor(string authorName, int authorID)
        {
            AuthorLogic authorLogic = new AuthorLogic();
            authorLogic.UpdateAuthor(authorName, authorID);
        }


        public void DeleteAuthor(int authorID)
        {
            AuthorLogic authorLogic = new AuthorLogic();
            authorLogic.DeleteAuthor(authorID);
        }
    }
}
