function addToCart(productName, price) {
    var cart = document.getElementById('cart');
    var item = document.createElement('div');
    item.classList.add('cart-item');
    item.innerHTML = '<span>' + productName + ' - Prezzo: €' + price + '</span><button onclick="removeFromCart(this)">Elimina</button>';
    cart.appendChild(item);

    var cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
    cartItems.push({ productName: productName, price: price });
    localStorage.setItem('cartItems', JSON.stringify(cartItems));

    updateTotal();
}

function removeFromCart(button) {
    var item = button.parentNode;
    var cart = document.getElementById('cart');
    cart.removeChild(item);

    var productName = item.querySelector('span').textContent.split(' - ')[0];
    var cartItems = JSON.parse(localStorage.getItem('cartItems'));
    cartItems = cartItems.filter(function(item) {
        return item.productName !== productName;
    });
    localStorage.setItem('cartItems', JSON.stringify(cartItems));

    updateTotal();
}

function updateTotal() {
    var cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
    var total = 0;
    cartItems.forEach(function(item) {
        total += item.price;
    });
    document.getElementById('total').textContent = 'Totale: €' + total;
}

window.onload = function() {
    var cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
    var cart = document.getElementById('cart');

    cartItems.forEach(function(item) {
        var cartItem = document.createElement('div');
        cartItem.classList.add('cart-item');
        cartItem.innerHTML = '<span>' + item.productName + ' - Prezzo: €' + item.price + '</span><button onclick="removeFromCart(this)">Elimina</button>';
        cart.appendChild(cartItem);
    });

    updateTotal();
};
function acquista(){
alert("Acquisto effettuato.");
var img = document.createElement("img");
img.src = "img/Giggi.jpeg";
img.width = 500;
var fotoContainer = document.getElementById("fotoContainer");
fotoContainer.innerHTML="";
fotoContainer.appendChild(img);
}