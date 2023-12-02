using System;
using System.Collections.Generic;
using System.Windows.Forms;
using Controller;
using DTO;

namespace WindowsFormAppLibrarySystem
{
    public partial class FormDisplayUserBookServices : Form
    {
        // connect to the Controllers
        BookController bookController = new BookController();
        BorrowController borrowController = new BorrowController();
        ReservedController reservedController = new ReservedController();

        // username
        string username = "";

        public FormDisplayUserBookServices(string name)
        {
            InitializeComponent();
            // set welcome message
            username = name;
            label2.Text = "Welcome " + username;

            // load user's borrowed and reserved books
            List<BorrowDTO> borrowDTOs = borrowController.FindBorrowByUserID(username);
            List<ReservedDTO> reservedDTOs = reservedController.FindReservedByUserID(username);

            // display the data
            dataGridView2.DataSource = borrowDTOs;
            dataGridView3.DataSource = reservedDTOs;

            // hide error message
            label1.Visible = false;
        }


        private void GetAllBooksBtn(object sender, EventArgs e)
        {
            List<BookDTO> bookDTOs = bookController.GetAllBooks();

            // display the data
            dataGridView1.DataSource = bookDTOs;
        }

        private void BorrowBookBtn(object sender, EventArgs e)
        {
            bool successfullBorrow = borrowController.BorrowBook(textBox1.Text, username);
            if (successfullBorrow)
            {
                // reload view to see updated data
                List<BorrowDTO> borrowDTOs = borrowController.FindBorrowByUserID(username);
                dataGridView2.DataSource = borrowDTOs;
                label1.Visible = false;
            }
            else
            {
                // show error message
                label1.Visible = true;
            }
        }

        private void ReserveBookBtn(object sender, EventArgs e)
        {
            bool successfullBorrow = reservedController.ReserveBook(textBox1.Text, username);
            if (successfullBorrow)
            {
                // reload view to see updated data
                List<ReservedDTO> reservedDTOs = reservedController.FindReservedByUserID(username);
                dataGridView3.DataSource = reservedDTOs;
                label1.Visible = false;
            }
            else
            {
                // show error message
                label1.Visible = true;
            }
        }

        private void ReturnBookBtn(object sender, EventArgs e)
        {
            bool successfullReturn = borrowController.ReturnBook(textBox1.Text, username);
            if (successfullReturn)
            {
                // reload view to see updated data
                List<BorrowDTO> borrowDTOs = borrowController.FindBorrowByUserID(username);
                dataGridView2.DataSource = borrowDTOs;
                label1.Visible = false;
            }
            else
            {
                // show error message
                label1.Visible = true;
            }
        }



        private void ExitBtn(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you want to close this form?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // close program
                Application.Exit();
            }
        }
        private void LogoutBtn(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you'd like to logout?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // show login window
                FormDisplayLogin loginWindow = new FormDisplayLogin();
                loginWindow.Visible = true;

                // hide current window
                this.Visible = false;
            }
        }
        private void BackToDashboardBtn(object sender, EventArgs e)
        {
            // show dahsboard window
            FormDisplayUserDashboard dashboardWindow = new FormDisplayUserDashboard(username);
            dashboardWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
    }
}
