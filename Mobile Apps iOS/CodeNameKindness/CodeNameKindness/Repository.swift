//
//  Repository.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 26/7/2024.
//

import Foundation
import FirebaseFirestore
import FirebaseAuth

class Repository {
    var db = Firestore.firestore()
    
    // add agent for signup call
    func addAgent(agent: Agent) -> Bool {
        // get random mission
        let randomMission = Utility.getRandomMission(from: Utility.missionsArr)
        
        var result = true
        var dictionary: [String: Any] = [
            "agentName": "CodeName" + agent.agentName,
            "currentMission": randomMission ?? "Somehow ran out of missions?",
            "level": agent.level,
            "exp": agent.exp,
            "badges": agent.badges,
            "friends": agent.friends
        ]
        
        db.collection("agents").document(agent.id).setData(dictionary){ error in
        
            if let err = error {
                print("agent could not be added \(agent.agentName), error \(err)")
                result = false
            }
        }
        
        return result
    }
    
    
    // get agent for initial load in headquarters
    func fetchAgent(withId id: String, completion: @escaping (Agent?, Error?) -> Void) {
        // ref to the agent's doc
        let docRef = db.collection("agents").document(id)
        
        // add listener for live updates
        docRef.addSnapshotListener { documentSnapshot, error in
            if let error = error {
                completion(nil, error)
                return
            }

            guard let document = documentSnapshot, document.exists, let data = document.data() else {
                completion(nil, nil) // no doc
                return
            }

            let agent = Agent(id: id, dictionary: data)
            completion(agent, nil)
        }
    }
    
    
    // update agent exp for completing mission
    func updateAgentExpAndLevel(withId id: String, newExp: Int, newLevel: Int, newMission: String, completion: @escaping (Error?) -> Void) {
        // agents coll with specific docID
        let docRef = db.collection("agents").document(id)
        
        // ppdate exp and level fields
        docRef.updateData([
            "currentMission": newMission,
            "exp": newExp,
            "level": newLevel
        ]) { error in
            if let error = error {
                // error
                print("Error updating exp and level: \(error.localizedDescription)")
                completion(error)
            } else {
                // success
                print("Agent exp and level updated successfully")
                completion(nil)
            }
        }
    }
}
