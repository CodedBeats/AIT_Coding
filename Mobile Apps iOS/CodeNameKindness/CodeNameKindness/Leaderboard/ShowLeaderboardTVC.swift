//
//  ShowLeaderboardTVC.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 27/7/2024.
//

import UIKit

class ShowLeaderboardTVC: UITableViewController {
    
    let repository = Repository()
    // all agents arr
    var agents = [Agent]()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // get all agents
        repository.fetchAllAgentsSortedByLevel { [weak self] (agents, error) in
            if let error = error {
                print("error fetching agents: \(error.localizedDescription)")
                
            } else if let agents = agents {
                self?.agents = agents
                self?.tableView.reloadData()
            }
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return agents.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "AgentRankedCell", for: indexPath) as! AgentRankedTVCell
        
        // get agent data for cell
        let agent = agents[indexPath.row]
        
        // customise cell
        cell.rankingLabel.text = "#\(indexPath.row + 1)"
        cell.agentNameLabel.text = agent.agentName
        cell.levelLabel.text = "Level \(agent.level)"
        
        // handle friended or not
        // cell.friendBtn.setTitle("Add Friend", for: .normal)
        
        return cell
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
