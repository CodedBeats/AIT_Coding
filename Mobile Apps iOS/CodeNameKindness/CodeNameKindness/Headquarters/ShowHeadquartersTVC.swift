//
//  ShowHeadquartersTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 27/7/2024.
//

import UIKit
import FirebaseAuth

class ShowHeadquartersTVC: UITableViewController {
    
    @IBOutlet weak var agentNameLabel: UILabel!
    @IBOutlet weak var agentLevelLabel: UILabel!
    @IBOutlet weak var agentExpProgress: UIProgressView!
    @IBOutlet weak var currentMissionLabel: UILabel!
    
    var agent: Agent!
    let service = Repository()
    var userAuthId: String!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // remove weird overlaying background when scrolling
        navigationController?.navigationBar.barTintColor = UIColor.black
        navigationController?.navigationBar.isTranslucent = false
        tabBarController?.tabBar.barTintColor = UIColor.black
        tabBarController?.tabBar.isTranslucent = false
        

        userAuthId = Auth.auth().currentUser?.uid
        print("Currenr User ID: \(userAuthId ?? "NIL")")
        
        service.fetchAgent(withId: userAuthId) { (returnedAgent, error) in
            if let err = error {
                print("Error fetching agent: \(err.localizedDescription)")
                
            } else if let fetchedAgent = returnedAgent {
                // success
                print("Fetched Agent: \(fetchedAgent.agentName)")
                self.agent = fetchedAgent
                
                // load agent data onto screen
                self.agentNameLabel.text = self.agent.agentName
                self.agentLevelLabel.text = String(self.agent.level) // convert Int to String
                self.agentExpProgress.progress = Float(self.agent.exp) / 100.0 // convert Int to Float for progress bar
                self.currentMissionLabel.text = self.agent.currentMission
            } else {
                print("Agent not found")
            }
        }
    }
    
    
    

    // MARK: - Table view data source

    /*
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)

        // Configure the cell...

        return cell
    }
    */

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        
        if let agentReportTVC = segue.destination as? ShowAgentReportTVC {
            agentReportTVC.agent = self.agent
        }
        
        if let missionTVC = segue.destination as? ShowMissionTVC {
            missionTVC.agent = self.agent
        }
            
    }

}
