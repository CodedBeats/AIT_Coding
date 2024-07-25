//
//  LoginVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 26/7/2024.
//

import UIKit
import FirebaseAuth

class LoginVC: UIViewController {
  
    
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        do {
            try Auth.auth().signOut()
        } catch let signOutError as NSError {
            // Show error message
        }
    }
    
    
    
    
    @IBAction func forgottenPasswordDidPress(_ sender: Any) {
        guard !emailTextField.text.isBlank else{
            self.showAlertMessage(title: "Email is Empty", message: "Please input your email")
            return
        }
        
        Auth.auth().sendPasswordReset(withEmail: emailTextField.text!){ error in
            if let error = error {
                self.showAlertMessage(title: "Error", message: "\(error)")
                
                return
            }
            
            self.showAlertMessage(title: "Email Confirmation", message: "A confirmation email has been sent to you email account")
          }
    }
    
    
    
    @IBAction func loginDidPress(_ sender: Any) {
        guard !emailTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Email is mandatory")
            return
        }
        
        guard !passwordTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Password is mandatory")
            return
        }
        
        let email = emailTextField.text!
        let password = passwordTextField.text!
        
        Auth.auth().signIn(withEmail: email, password: password) { [weak self] authResult, error in
            guard error == nil else {
                self?.showAlertMessage(title: "Failed to login", message: "\(error!.localizedDescription)")
                return
            }
            
            guard let authUser = Auth.auth().currentUser, authUser.isEmailVerified else {
                self?.showAlertMessage(title: "Pending email verification", message: "We've sent you an email to verify your account, please follow the instructions")
                return
            }
            
            // let user pass to next screen because log in successfull
            let homeViewController = self?.storyboard?.instantiateViewController(identifier: "HomeVC") as? UITabBarController
            
            self?.view.window?.rootViewController = homeViewController
            self?.view.window?.makeKeyAndVisible()
            
            
        }
        
        let uid = Auth.auth().currentUser?.uid ?? ""
        print("Log in userID: \(uid)")
        
    }
    
    
}
