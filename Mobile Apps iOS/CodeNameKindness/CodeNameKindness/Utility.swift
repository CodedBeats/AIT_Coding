//
//  Utility.swift
//  CodeNameKindness
//
//  Created by Luca Haar on 28/7/2029. :) Do you read these?
//

import Foundation

class Utility {
    // array of missions
    static let missionsArr: [String] = [
        "Take a few minutes to call your parents or a family member for a little chat",
        "Give a genuine compliment to a friend or colleague to brighten their day",
        "If you see some litter on the ground, pick it up and throw it away",
        "Hold the door open for someone behind you",
        "Share a warm smile with someone you pass by",
        "Express your appreciation to a service worker, like a cashier or delivery person",
        "Go through your closet and donate clothes you no longer wear",
        "Leave a positive note for someone to find, like on a coworker's desk",
        "Help a neighbor with groceries or any small task they might need assistance with",
        "Recommend or lend a good book or movie to a friend"
    ]

    // get random mission from missions
    static func getRandomMission(from array: [String]) -> String? {
        return array.randomElement()
    }
    
    // handle increase of exp, level and badges
    static func calculateNewStats(currentExp exp: Int, currentLevel lvl: Int) -> (newExp: Int, newLvl: Int, badges: [String]) {
        var newLvl = lvl
        var newExp = exp + 30
        
        if newExp >= 100 {
            newExp -= 100
            newLvl += 1
        }
        
        // static for now
        let badges = ["badge_1", "badge_2", "badge_3"]
        
        return (newExp, newLvl, badges)
    }
}

