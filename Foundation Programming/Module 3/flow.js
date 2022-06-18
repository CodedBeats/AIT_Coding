let fibonacci = () => {
    let result = "0, 1, "
    let total = 0
    let count = 2
    let x = 0
    let y = 1
    for (let i = 0; i < 20; i++) {
        total = x + y
        result += `${total.toString()}, `
        x = y
        y = total
        count += 1
    } console.log(result)
}