using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Controller;

namespace WindowsFormAppLibrarySystem
{
    public partial class Form1 : Form
    {
        UserController userController = new UserController();

        public Form1()
        {
            InitializeComponent();
        }

        private void GetUserBtn(object sender, EventArgs e)
        {
            string username = userController.GetUser(Int32.Parse(textBox1.Text));

            textBox2.Text = username;
        }
    }
}
