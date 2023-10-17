using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using Crapulator_Controller;

namespace Crapulator_Display
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        // operator state
        private string operatorVal = "";

        // create calculator controller
        Crapulator_Controller1 c = new Crapulator_Controller1();

        private void button10_Click(object sender, EventArgs e)
        {

        }




        // === Calc num btns === //
        private void decimalPointBtn(object sender, EventArgs e)
        {
            updateTextBox(".");
        }
        private void num1Btn(object sender, EventArgs e)
        {
            updateTextBox("1");
        }
        private void num2Btn(object sender, EventArgs e)
        {
            updateTextBox("2");
        }
        private void num3Btn(object sender, EventArgs e)
        {
            updateTextBox("3");
        }
        private void num4Btn(object sender, EventArgs e)
        {
            updateTextBox("4");
        }
        private void num5Btn(object sender, EventArgs e)
        {
            updateTextBox("5");
        }
        private void num6Btn(object sender, EventArgs e)
        {
            updateTextBox("6");
        }
        private void num7Btn(object sender, EventArgs e)
        {
            updateTextBox("7");
        }
        private void num8Btn(object sender, EventArgs e)
        {
            updateTextBox("8");
        }
        private void num9Btn(object sender, EventArgs e)
        {
            updateTextBox("9");
        }
        // ===  === //



        // === Functional Btns === //
        private void equalBtn(object sender, EventArgs e)
        {
            textBox3.Text = "=";

            c.updateCalcNum(Convert.ToDouble(textBox1.Text), false);

            // perform operation
            double ans = c.handleOperation(operatorVal);

            // update textbox2 with answer
            textBox2.Text = $"{ans}";

        }
        private void addBtn(object sender, EventArgs e)
        {
            c.updateCalcNum(Convert.ToDouble(textBox1.Text), true);

            operatorVal = "+";
            textBox3.Text = "+";
            textBox1.Clear();
        }
        private void subBtn(object sender, EventArgs e)
        {
            c.updateCalcNum(Convert.ToDouble(textBox1.Text), true);

            operatorVal = "-";
            textBox3.Text = "-";
            textBox1.Clear();
        }
        private void multiplyBtn(object sender, EventArgs e)
        {
            c.updateCalcNum(Convert.ToDouble(textBox1.Text), true);

            operatorVal = "*";
            textBox3.Text = "x";
            textBox1.Clear();
        }
        private void divBtn(object sender, EventArgs e)
        {
            c.updateCalcNum(Convert.ToDouble(textBox1.Text), true);

            operatorVal = "/";
            textBox3.Text = "/";
            textBox1.Clear();
        }
        // ===  === //



        // === misc btns === //
        // clear both text boxes and reset variables
        private void clearBtn(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
            c.clearNums();
            operatorVal = string.Empty;
        }
        // exit btn
        private void exitBtn(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you want to close this form?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // close program
                Application.Exit();
            }
        }
        // delete btn
        private void delBtn(object sender, EventArgs e)
        {
            // get the current text
            string currentText = textBox1.Text;

            // check if the text box is not empty
            if (!string.IsNullOrEmpty(currentText))
            {
                // split text into arr
                char[] characters = currentText.ToCharArray();

                if (characters.Length > 0)
                {
                    // remove last character
                    Array.Resize(ref characters, characters.Length - 1);

                    // new text
                    string updatedText = new string(characters);

                    // update text
                    textBox1.Text = updatedText;
                }
            }
        }
        // ===  === //



        // === misc funcs === //
        private void updateTextBox(string input)
        {
            textBox1.Text = $"{textBox1.Text + input}";
        }
        // ===  === //



        // === Text Boxes === //
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }
        // ===  === //
    }
}
