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
    var missions: [String] = ["x", "y", "z"]
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
        // agents coll with specific docID
        let docRef = db.collection("agents").document(id)
        
        docRef.getDocument {(document, error) in
            if let error = error {
                // handle error
                completion(nil, error)
            } else if let document = document, document.exists {
                // get data
                if let data = document.data() {
                    let agent = Agent(id: id, dictionary: data)
                    
                    completion(agent, nil)
                } else {
                    // doc does not exist or is empty
                    print("Document does not exist or is empty")
                    completion(nil, nil)
                }
            } else {
                // doc doesn't exist
                print("Document not found")
                completion(nil, nil)
            }
        }
    }
    
    
    // update agent exp for completing mission
    func updateAgentExpAndLevel(withId id: String, newExp: Int, newLevel: Int, completion: @escaping (Error?) -> Void) {
        // agents coll with specific docID
        let docRef = db.collection("agents").document(id)
        
        // ppdate exp and level fields
        docRef.updateData([
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
