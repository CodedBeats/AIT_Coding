//
//  SignupVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 26/7/2024.
//

import UIKit
import FirebaseAuth

class SignupVC: UIViewController {
    
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var agentNameTextFeild: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var confirmPasswordTextField: UITextField!
    
    var service = Repository()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view
    }
    
    
    @IBAction func signUpDidPress(_ sender: Any) {
        guard !emailTextField.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Email is Mandatory")
            return
        }
        
        guard !agentNameTextFeild.text.isBlank else {
            showAlertMessage(title: "Validation", message: "Choose your Agent Name")
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
              let agentName = agentNameTextFeild.text,
              let password = passwordTextField.text,
              let confirmation = confirmPasswordTextField.text,
              password == confirmation else {
            
            showAlertMessage(title: "Validation", message: "Password and Password Confirmation do not match")
            return
        }
        
        
        // closure with the code to be executed when the user presses Sign Up
        let registerUserClosure : () -> Void = {
            // code that will be execute when the closure is called
            // register the user in the firestore
            let userAuthId = Auth.auth().currentUser?.uid
            // validate userAuthId is not nil
            print("signed up id \(userAuthId ?? "NIL")")
            let agent = Agent( id: userAuthId!,
                               agentName: agentName,
                               currentMission: "blank",
                               level: 1,
                               exp: 0,
                               badges: ["none"]
                             )
            
            // create user in the DB
            if self.service.addAgent(agent: agent) {
                print("Agent Added: \(agent.agentName)")
            }
            
            self.navigationController?.popViewController(animated: true)
        }
        
        
        // user Firebase Auth
        Auth.auth().createUser(withEmail: email, password: password) { authResult, error in
            guard error == nil else {
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
            self.showAlertMessageWithHandle(title: "Email Confirmation Sent",
                                            message: "A confirmation email has been sent to your email account, please confirm your account before you log in",
                                            onComplete: registerUserClosure)
            
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
