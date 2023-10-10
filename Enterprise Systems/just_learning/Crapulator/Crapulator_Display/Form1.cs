using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Crapulator;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Crapulator_Display
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        // num states
        private bool num1Status = true;
        private bool num2Status = false;

        // create calculator obj
        Calculator c = new Calculator();

        // === misc funcs === //
        private void updateTextBox(int input)
        {
            textBox1.Text = $"{textBox1.Text + input}";
        }
        // ===  === //

        private void button10_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {

        }
        private void button4_Click(object sender, EventArgs e)
        {

        }

        // clear both text boxes
        private void clearBtn(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
        }

        // exit btn
        private void exitBtn_click(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you want to close this form?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // close program
                Application.Exit();
            }
        }

        // === Calc num btns === //
        private void num1Btn(object sender, EventArgs e)
        {
            updateTextBox(1);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num2Btn(object sender, EventArgs e)
        {
            updateTextBox(2);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num3Btn(object sender, EventArgs e)
        {
            updateTextBox(3);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num4Btn(object sender, EventArgs e)
        {
            updateTextBox(4);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num5Btn(object sender, EventArgs e)
        {
            updateTextBox(5);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num6Btn(object sender, EventArgs e)
        {
            updateTextBox(6);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num7Btn(object sender, EventArgs e)
        {
            updateTextBox(7);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num8Btn(object sender, EventArgs e)
        {
            updateTextBox(8);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }
        private void num9Btn(object sender, EventArgs e)
        {
            updateTextBox(9);
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }


        // ===  === //


        // === Functional Btns === //
        private void equalBtn(object sender, EventArgs e)
        {
            textBox2.Text = textBox1.Text;
        }

        private void addBtn(object sender, EventArgs e)
        {
            c.Num1 = Convert.ToDouble(textBox1.Text);
        }

        // ===  === //
    }
}
