//
//  SignupVC.swift
//  iostestdomain
//
//  Created by Luca Haar on 28/6/2024.
//

import UIKit
import FirebaseAuth

class SignupVC: UIViewController {
    

    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var confirmPasswordTextField: UITextField!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    @IBAction func signupDidPress(_ sender: Any) {
        guard !emailTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Email is Mandatory")
            return
        }
        
        guard !passwordTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Password is Mandatory")
            return
        }
        
        guard !confirmPasswordTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Password Confirmation is Mandatory")
            return
        }
        
        // validate passwords match
        guard let email = emailTextField.text,
              let password = passwordTextField.text,
              let confirmation = confirmPasswordTextField.text,
              password == confirmation else {
            
            showAlertMessage(title: "Validation", message: "Password and Password Confirmation do not match")
            return
        }
        
        
        // user FIrebase Auth -> create user and send confirmation email
        Auth.auth().createUser(withEmail: email, password: password) { authResult, error in
            // guard for 
            guard error == nil else  {
                self.showAlertMessage(title: "We could not create the account", message: "\(error!.localizedDescription)")
                return
            }
            
            // send the email confirmation
            Auth.auth().currentUser?.sendEmailVerification { error in
                // unwrap and see if there is an error
                if let error = error {
                    self.showAlertMessage(title: "Error", message: "\(error.localizedDescription)")
                    return
                }
            }
            self.showAlertMessage(title: "Email Confirmation", message: "A confirmation email has been sent to your email account")
            
        }
    }
    
    
    
    
    
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
