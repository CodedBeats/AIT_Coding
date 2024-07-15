import Foundation


// === Variables ===
print("\n=== Variables ===\n")
var mutableVar = 1
mutableVar = 2
let constantVar = 3
print("{\(mutableVar)} can be changed but {\(constantVar)} is constant")
print("\n")



// === Closures ===
print("\n=== Closures ===\n")

// closure with 1 param and no return
let greetUserClosure: (String) -> Void = { myName in
    print("My name is, My name is, My name is, \(myName)")
}
greetUserClosure("Slim Shady")
print("\n")

// closure with 1 param and return val
let calculateSquareArea1: (Double) -> Double = {(side) in
    return side * side
}
// same but no definition for return type
let calculateSquareArea2 = {(anotherSide: Double) in
    return anotherSide * anotherSide
}
// call the closure
let squareArea1 = calculateSquareArea1(3.0)
let squareArea2 = calculateSquareArea1(2.0)
print("the area of the square1 is: \(squareArea1)")
print("the area of the square2 is: \(squareArea2)")
print("\n")


// closure with multiple params and return val
let calcRectangleArea: (Double, Double) -> Double = {(length, width) in
    return length * width
}
let rectangleArea = calcRectangleArea(4.0,3.0)
print("the rectangle's area is \(rectangleArea)")
print("\n")



// === Closures as func params ===
print("\n=== Closures as Function Parameter ===\n")

// decleration of function recieving a closure without params or return
func grabLunch(search: () -> ()) {
    print("what's going on here?")
    // call closure
    search()
}
// call func passing closure
grabLunch(search: {
    print("Luca is really hungry for sweets")
    print("Foo is always hungry")
})
print("\n")



// === Trailing closures ===
// ~When a function accepts a closure as it's last param (grabLunch actually does this)
// Therefore you can omit the parenthesis when calling the function, also you can call the function
// by passing the closure as a function body without mentioning the name of the param
print("\n=== Trailing Closures ===\n")

// void function that takes regular param and closure as last param (closure takes 1 param and no return)
func thisIsGettingComplicated(name: String, canGreet: (Bool) -> Void) {
    print("I AM THE \(name)!!!!")
    canGreet(true)
}
thisIsGettingComplicated(name: "UNDERMINERRR", canGreet: {bool in
    if (bool) {
        print("how are you lol")
    }
    else {
        print("AHHH, I'm a rat")
    }
})
print("\n")


// function that returns an arr of  "n" random chars from the alphabet
// takes int as first param and closure as last param
func findAlphabetLetter(number n: Int, completion: () -> Void) -> [Character] {
    var selectedChars: [Character] = []
    let letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWQYZ"
    var selectedChar: Character
    
    // can use "_" since a var would never be used
    for _ in 1...n {
        selectedChar = letters.randomElement()!
        selectedChars.append(selectedChar)
    }
    
    // call closure
    completion()
    
    return selectedChars
}

var randomCharacters: [Character] = []
randomCharacters = findAlphabetLetter(number: 13) {
    print("The selected characters are: ")
}
print(randomCharacters)
print("\n")



// === Escaping closure ===
// ~When a closure is passed as an argument to the function but that closure needs to be
// executed after the function returns, then such tpe of closure is known as escaping closure
print("\n=== Escaping Closures ===\n")

func escapingClosureFunc(number n: Int, completion: @escaping (String) -> Void) {
    print("Escaping closure START")
    let test = "ABCX"
    completion(test)
    print("Escaping closure END")
}
var aBadlyNamedVar = ""
escapingClosureFunc(number: 3) { (value) in
    aBadlyNamedVar = value
    print(aBadlyNamedVar)
}
print("I am outside: \(aBadlyNamedVar)")
print("\n")



// === Classes ===
print("\n=== Classes ===\n")

class Force {
    var strength: Int
    var essence: String
    
    init(strength: Int, essence: String) {
        self.strength = strength
        self.essence = essence
    }
    
    func printVals() {
        print("Strength: \(self.strength), Essence: \(self.essence)")
    }
}

class Jedi: Force {
    var name: String
    var rank: String
    let maxHealth: Int
    
    init(name: String, rank: String, maxHealth: Int, strength: Int) {
        self.name = name
        self.rank = rank
        self.maxHealth = maxHealth
        super.init(strength: strength, essence: "Light Side")
    }
    
    // cant have 2 inits, can have many convenience inits
    convenience init(name: String) {
        self.init(name: name, rank: "Apprentice", maxHealth: 50, strength: 10)
    }
    
    override func printVals() {
        print("Jedi: \(self.name), Rank: \(self.rank), Health: \(self.maxHealth)")
    }
}

class Sith: Force {
    var name: String
    var rank: String
    var lightning: Bool
    var weapon: String
    
    init(name: String, rank: String, lightning: Bool, weapon: String, strength: Int) {
        self.name = name
        self.rank = rank
        self.lightning = lightning
        self.weapon = weapon
        super.init(strength: strength, essence: "Dark Side")
    }
    
    override func printVals() {
        print("Sith: \(self.name), Rank: \(self.rank), Lightning: \(self.lightning), Weapon: \(self.weapon), Strength: \(self.strength)")
    }
}

// using a class
var luke = Jedi(name: "Luke Skywalker")
luke.printVals()
var yoda = Jedi(name: "Yoda", rank: "Master", maxHealth: 999, strength: 20)
yoda.printVals()
var darthMall = Sith(name: "Darth Mall", rank: "Knight", lightning: false, weapon: "Double-Sided Light Sabre", strength: 2)
darthMall.printVals()
// create pointer var
var lukePoints = luke
lukePoints.name = "Luke Points"
luke.printVals()
print("\n")



// === Extensions ===
// ~Adds code (like functions and properties) to types and classes
// really useful, think like custom exceptions
print("\n=== Extensions ===\n")
extension String {
    func myOwnStringFunc() {
        print("I have this capability now")
    }
}

var codersName: String = "Luca"
codersName.myOwnStringFunc()
print("\n")

// extending Optional specifying what content it has
extension Optional where Wrapped == String {
    // is blank tells if string is nill or has empty spaces as value
    var isBlank: Bool {
        // check something at beginning of prcedure and exit if it doesn't match
        guard let notNilBool = self else {
            // the value wrapped in the optional is nill
            return true
        }
        
        return notNilBool.trimmingCharacters(in: .whitespaces).isEmpty
    }
}
// create optional with string content
var maybeBlankVal: String?
print(maybeBlankVal.isBlank)


