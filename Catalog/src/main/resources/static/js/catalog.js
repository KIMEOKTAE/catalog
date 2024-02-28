  
document.addEventListener('DOMContentLoaded', function() {
    // 페이지가 로드될 때 초기 Total price를 계산합니다.
    calculateTotalPrice();

    // 체크박스의 상태가 변경될 때마다 Total price를 업데이트합니다.
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            calculateTotalPrice();
        });
    });
});

function toggleshow(clickedDiv) {
    clickedDiv.classList.add('show');
    var parent = clickedDiv.parentNode; // 클릭된 요소의 부모 요소를 가져옵니다.
    var siblings = parent.children; // 부모 요소의 자식 요소들을 가져옵니다.
    
    // 부모 요소의 자식 요소들을 순회하며, 현재 클릭된 요소가 아닌 다른 요소에서는 show 클래스를 제거합니다.
    for (var i = 0; i < siblings.length; i++) {
        var sibling = siblings[i];
        if (sibling !== clickedDiv && sibling.classList.contains('information')) {
            sibling.classList.remove('show');
        }
    }
}
function calculateTotalPrice() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    var totalPrice = 0;
    checkboxes.forEach(function(checkbox) {
        totalPrice += parseInt(checkbox.value);
    });
    document.getElementById('totalPrice').textContent = 'Total price : ' + totalPrice;
}

function togglecategory(clickedDiv) {
    var information = clickedDiv.querySelector('.information');

    // 현재 클릭된 div 요소의 클래스에 'on'이 있으면 해당 클래스를 제거하고, 없으면 추가합니다.
    if (clickedDiv.classList.contains('on')) {
        // 클릭된 요소에 'on' 클래스가 이미 있는 경우에는 추가적인 작업을 수행하지 않습니다.
        return;
    } else {
        clickedDiv.classList.add('on');

        // 클릭된 요소에 'on' 클래스가 있는 경우에는 하위 요소를 보여줍니다.
        information.style.display = 'inline-block';

        // 하위 요소의 'show' 클래스를 추가합니다.
        var children = information.querySelectorAll('.information');
        children.forEach(function(child) {
            child.classList.add('show');
        });
    }

    // 다른 category 클래스를 가진 요소에서 'on' 클래스를 제거합니다.
    var categories = document.querySelectorAll('.category');
    categories.forEach(function(category) {
        if (category !== clickedDiv && category.classList.contains('on')) {
            category.classList.remove('on');
            // 제거된 요소의 하위 요소도 숨깁니다.
            var information = category.querySelector('.information');
            information.style.display = 'none';

            // 하위 요소의 'show' 클래스를 제거합니다.
            var children = information.querySelectorAll('.information');
            children.forEach(function(child) {
                child.classList.remove('show');
            });
        }
    });
}