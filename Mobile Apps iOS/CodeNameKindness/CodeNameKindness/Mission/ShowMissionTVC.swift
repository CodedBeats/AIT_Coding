//
//  ShowMissionTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 27/7/2024.
//

import UIKit
import FirebaseAuth

class ShowMissionTVC: UITableViewController {
    
    @IBOutlet weak var currentMissionLabel: UILabel!
    
    let service = Repository()
    var userAuthId: String!
    
    var agent: Agent!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        currentMissionLabel.text = agent.currentMission
    }
    
    
    
    @IBAction func completeMissionBtnDidPress(_ sender: Any) {
        // unwrap user ID
        guard let userAuthId = Auth.auth().currentUser?.uid else {
            print("User not authenticated")
            return
        }
        
        // get random mission
        guard let randomMission = Utility.getRandomMission(from: Utility.missionsArr) else {
            print("Failed to get a random mission")
            return
        }
        
        // unwrap agent's level and exp
        guard let currentLevel = agent?.level, let currentExp = agent?.exp else {
            print("Agent data is not available")
            return
        }
        
        // calculate new experience, level and badges (seperate func just for cleanness)
        let newStats = Utility.calculateNewStats(currentExp: currentExp, currentLevel: currentLevel)
        let newExp = newStats.newExp
        let newLvl = newStats.newLvl
        let newBadges = newStats.badges
        
        // update agent
        service.updateAgentStats(withId: userAuthId, newExp: newExp, newLevel: newLvl, newBadges: newBadges, newMission: randomMission) { error in
            if let error = error {
                // error
                print("Error updating agent: \(error.localizedDescription)")
            } else {
                // success
                print("Agent updated successfully")
                
                // update agent object locally...this might be wrong :(
                self.agent?.level = newLvl
                self.agent?.exp = newExp
                self.agent?.currentMission = randomMission
                
                // update UI to reflect changes
                self.currentMissionLabel.text = randomMission
            }
        }
    }
    
    @IBAction func passMissionBtnDidPress(_ sender: Any) {
        // unwrap user ID
        guard let userAuthId = Auth.auth().currentUser?.uid else {
            print("User not authenticated")
            return
        }
        
        // get random mission
        guard let randomMission = Utility.getRandomMission(from: Utility.missionsArr) else {
            print("Failed to get a random mission")
            return
        }
        
        // unwrap agent's level and exp
        guard let currentLevel = agent?.level, let currentExp = agent?.exp else {
            print("Agent data is not available")
            return
        }
        
        // get agent's badges since they don't need to be changed
        let badges = agent.badges
        
        // Call the service to update the agent's data
        service.updateAgentStats(withId: userAuthId, newExp: currentExp, newLevel: currentLevel, newBadges: badges, newMission: randomMission)
        { error in
            if let error = error {
                // error
                print("Error updating agent: \(error.localizedDescription)")
            } else {
                // success
                print("Agent updated successfully")
                
                // update agent object locally...this might be wrong :(
                self.agent?.currentMission = randomMission
                
                // update UI to reflect changes
                self.currentMissionLabel.text = randomMission
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

}
