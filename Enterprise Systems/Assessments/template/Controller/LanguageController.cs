using DTO;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class LanguageController
    {
        public List<LanguageDTO> GetAllLanguages()
        {
            LanguageLogic languageLogic = new LanguageLogic();
            return languageLogic.GetAllLanguages();
        }

        public void CreateLanguage(string languageName)
        {
            LanguageLogic languageLogic = new LanguageLogic();
            languageLogic.CreateLanguage(languageName);
        }

        public void UpdateLanguage(string languageName, int languageID)
        {
            LanguageLogic languageLogic = new LanguageLogic();
            languageLogic.UpdateLanguage(languageName, languageID);
        }

        public void DeleteLanguage(int languageID)
        {
            LanguageLogic languageLogic = new LanguageLogic();
            languageLogic.DeleteLanguage(languageID);
        }
    }
}
