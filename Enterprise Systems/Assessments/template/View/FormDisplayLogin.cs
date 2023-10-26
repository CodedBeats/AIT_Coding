using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace View
{
    public partial class FormDisplayLogin : Form
    {
        public FormDisplayLogin()
        {
            InitializeComponent();
        }

        private void LoginBtn(object sender, EventArgs e)
        {
            
            // successful login
            // show user dashboard
            FormDisplayUsers formDisplayUsers = new FormDisplayUsers();
            formDisplayUsers.Visible = true;
            // hide login screen
            this.Visible = false;
        }
    }
}
