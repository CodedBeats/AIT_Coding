using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class LanguageLogic
    {
        public List<Language> GetAllLanguages()
        {
            LanguageDAO languageDAO = new LanguageDAO();
            // create list of languages
            List<Language> languages = languageDAO.GetAllLanguages();

            return languages;
        }


        // CRUD
        public void CreateLanguage(string languageName)
        {
            LanguageDAO languageDAO = new LanguageDAO();
            languageDAO.CreateLanguage(languageName);
        }


        public void UpdateLanguage(string languageName, int languageID)
        {
            LanguageDAO languageDAO = new LanguageDAO();
            languageDAO.UpdateLanguage(languageName, languageID);
        }


        public void DeleteLanguage(int languageID)
        {
            LanguageDAO languageDAO = new LanguageDAO();
            languageDAO.DeleteLanguage(languageID);
        }
    }
}
