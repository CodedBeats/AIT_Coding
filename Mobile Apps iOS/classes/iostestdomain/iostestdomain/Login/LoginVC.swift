//
//  LoginVC.swift
//  iostestdomain
//
//  Created by Luca Haar on 28/6/2024.
//

import UIKit
import FirebaseAuth

class LoginVC: UIViewController {

    
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    
    

    @IBAction func forgottenPasswordDidPress(_ sender: Any) {
        guard !emailTextField.text.isBlank else {
            self.showAlertMessage(title: "Email is empty", message: "Please input your email")
            return
        }
        
        Auth.auth().sendPasswordReset(withEmail: emailTextField.text!) { error in
            if let error = error {
                self.showAlertMessage(title: "Error", message: "\(error.localizedDescription)")
                return
            }
            
            self.showAlertMessage(title: "Reset Password", message: "A password reset email has been sent to your email account")
            
        }
    }
    
    
    @IBAction func loginDidPress(_ sender: Any) {
        guard !emailTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Email is Mandatory")
            return
        }
        
        guard !passwordTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Password is Mandatory")
            return
        }
        
        // unwrap values
        let email = emailTextField.text!
        let password = passwordTextField.text!
        
        // firebase -> login user
        Auth.auth().signIn(withEmail: email, password: password) { [weak self] authResult, error in
            guard error == nil else {
                self?.showAlertMessage(title: "Failed to Login", message: "\(error!.localizedDescription)")
                return
            }
        }
        
        // guard and check user has verified their account with the confirmation email
        guard let authUser = Auth.auth().currentUser, authUser.isEmailVerified else {
            self.showAlertMessage(title: "Pending email verification", message: "We've sent you an email to verify your account, please follow the instructions")
            return
        }
        
        // let user pass to next screen cause login was done
        showAlertMessage(title: "Welcome to my app", message: ":3")
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
