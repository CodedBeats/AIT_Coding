using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class LanguageLogic
    {
        public List<LanguageDTO> GetAllLanguages()
        {
            LanguageDAO languageDAO = new LanguageDAO();
            // create list of languages
            List<Language> languages = languageDAO.GetAllLanguages();

            // check if no languages
            if (languages == null)
            {
                return null;
            }

            // clone languages' data into LanguageDTO type languages
            List<LanguageDTO> languageDTOs = languages.Select(language => new LanguageDTO
            {
                LID = language.LID,
                LanguageName = language.LanguageName
            }).ToList();

            return languageDTOs;
        }


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
