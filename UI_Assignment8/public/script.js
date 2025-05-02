const formLabel = document.getElementById('formLabel');
const formInput = document.getElementById('formInput');
const radioContainer = document.getElementById('radioContainer');
const success = document.getElementById('success');
const formCon = document.getElementById("formContainer");


let step = 0;
const data = {};

const prices = {
    Cycle: [5, 100, 500],
    Motorcycle: [10, 200, 1000],
    Car: [20, 500, 3500]
};

const currencyRates = {
    INR: 1,
    USD: 0.012,
    YEN: 1.68
};

let selectedCurrency = 'INR';

// -------Function to handle all inputs for employee and vehicle----------
const handleNext = () => {
    const value = formInput.value.trim();

    switch (step) {
        /**To take employee name input */
        case 0:
            if (value.length < 2 || !/^[a-zA-Z ]+$/.test(value)) {
                alert("Please enter a valid full name.");
                return;
            }
            data.name = value;
            formLabel.textContent = `Hi ${data.name}! Can I know your gender?`;
            formInput.style.display = 'none';
            radioContainer.style.display = 'block';
            break;

        /**To take employee gender input */
        case 1: {
            const selectedGender = document.querySelector('input[name="gender"]:checked');
            if (!selectedGender) {
                alert("Please select your gender.");
                return;
            }
            data.gender = selectedGender.value;
            formLabel.textContent = "Enter your email";
            radioContainer.style.display = 'none';
            Object.assign(formInput, { type: 'email', value: '', style: { display: 'block' } });
            break;
        }

        /**To take employee gmail input */
        case 2:
            if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value)) {
                alert("Please enter a valid email.");
                return;
            }
            data.email = value;
            formLabel.textContent = "Create a password";
            Object.assign(formInput, { type: 'password', value: '' });
            formInput.addEventListener('input', handleInput);
            break;

        /**To take employee password input */
        case 3:
            if (!isPasswordValid(value)) {
                alert("Password must be 8+ characters with upper, lower, number, and special char.");
                return;
            }
            data.password = value;
            formLabel.textContent = "Confirm your password";
            formInput.value = '';
            break;

        /**To take employee confirm password input */
        case 4:
            if (value !== data.password) {
                alert("Passwords do not match.");
                return;
            }
            formInput.removeEventListener('input', handleInput);
            formInput.style.borderColor = 'black';
            formLabel.textContent = "Enter your contact number";
            Object.assign(formInput, { type: 'tel', value: '' });
            break;

        /**To take employee contact input and print the employee id */
        case 5:
            if (!/^\d{10,11}$/.test(value)) {
                alert("Enter a valid contact number.");
                return;
            }
            data.contact = value;
            data.employeeId = `EMP${Math.floor(1000 + Math.random() * 9000)}`;
            Object.assign(formInput.style, { display: 'none' });
            formLabel.style.display = 'none';
            success.innerHTML = `
        Employee Registered Successfully!<br>
        Your Employee ID: <strong>${data.employeeId}</strong>
      `;
            success.style.display = 'block';
            break;

        /**To take vehicle brand input */
        case 6:
            document.getElementById("form_head").textContent = "Vehicle Details";
            Object.assign(success.style, { display: 'none' });
            Object.assign(formLabel, { style: { display: 'block' }, textContent: "Enter your vehicle brand" });
            Object.assign(formInput, { type: 'text', value: '', style: { display: 'block' } });
            break;

        /**To take vehicle type input */
        case 7:
            formCon.style.height = "90vh";
            if (value.length < 2 || !/^[a-zA-Z ]+$/.test(value)) {
                alert("Please enter a valid vehicle brand.");
                return;
            }
            data.vehicleBrand = value;
            formInput.style.display = 'none';
            formLabel.textContent = "Select your vehicle type";
            radioContainer.innerHTML = `
        <label><input type="radio" name="type" value="Cycle"> Cycle</label>
        <label><input type="radio" name="type" value="Motorcycle"> Motorcycle</label>
        <label><input type="radio" name="type" value="Car"> Car</label>
      `;
            radioContainer.style.display = 'block';
            break;

        /**To take vehicle number input */
        case 9: {
            const selectedType = document.querySelector('input[name="type"]:checked');
            if (!selectedType) {
                alert("Please select your vehicle type.");
                return;
            }
            data.vehicleType = selectedType.value;
            formLabel.textContent = "Enter your vehicle number";
            Object.assign(formInput, { type: 'text', value: '', style: { display: 'block' } });
            radioContainer.style.display = 'none';
            break;
        }

        /**Printing all info about vehicle */
        case 10:
            if (!value) {
                alert("Please enter your vehicle number.");
                return;
            }
            formCon.style.height = "50vh";
            data.vehicleNumber = value;
            success.innerHTML = `
        Vehicle Registered Successfully!<br>
        Employee ID: <strong>${data.employeeId}</strong><br>
        Vehicle Type: <strong>${data.vehicleType}</strong><br>
        Vehicle Brand: <strong>${data.vehicleBrand}</strong><br>
        Vehicle Number: <strong>${data.vehicleNumber}</strong>
      `;
            success.style.display = 'block';
            document.getElementById('registrationForm').style.display = 'none';
            showPassOptions(data.vehicleType);
            break;
    }
    step++;
};

// checking strength of password
const checkPasswordStrength = (pwd) => {
    let score = 0;
    if (/[A-Z]/.test(pwd)) score++;
    if (/[a-z]/.test(pwd)) score++;
    if (/\d/.test(pwd)) score++;
    if (/[^A-Za-z0-9]/.test(pwd)) score++;
    return score < 2 ? 'weak' : score === 4 ? 'strong' : 'normal';
};

// checking password is valid or not
const isPasswordValid = (pwd) =>
    pwd.length >= 8 &&
    /[A-Z]/.test(pwd) &&
    /[a-z]/.test(pwd) &&
    /\d/.test(pwd) &&
    /[^A-Za-z0-9]/.test(pwd);

// changing border color according to password
const setPasswordBorder = (strength) => {
    const colors = {
        weak: '3px solid red',
        normal: '3px solid orange',
        strong: '3px solid green'
    };
    formInput.style.border = colors[strength];
};

const handleInput = (e) => {
    const strength = checkPasswordStrength(e.target.value);
    setPasswordBorder(strength);
};

// method to print the passes according to vehicle type choosen
const showPassOptions = (vehicleType) => {
    const [daily, monthly, yearly] = prices[vehicleType];
    const converted = [daily, monthly, yearly].map(
        (p) => (p * currencyRates[selectedCurrency]).toFixed(2)
    );
    const passOptionsContainer = document.getElementById("passOptionsContainer");

    passOptionsContainer.innerHTML = `
    <h2 style="text-align:center; font-size:25px;">Choose a ${vehicleType} Pass</h2>
    <div style="text-align:center; margin: 10px;">
      <label style="font-size:20px">Choose Currency: </label>
      <select style="width:100px;height:30px" id="currencySelect">
        ${Object.keys(currencyRates).map(cur => `
          <option value="${cur}"${selectedCurrency === cur ? ' selected' : ''}>${cur}</option>
        `).join('')}
      </select>
    </div>
    <div class="pricing">
      ${['Daily', 'Monthly', 'Yearly'].map((type, i) => `
        <div class="vehicle_price">
          <h3>${type}</h3>
          <div class="circle">
            <p class="price">${converted[i]} ${selectedCurrency}</p>
          </div>
          <button class="purchase_button" onclick="selectPlan('${type}', ${converted[i]})">Get Pass</button>
        </div>
      `).join('')}
    </div>
    <div id="finalPrice"></div>
  `;

    document.getElementById("currencySelect").addEventListener('change', () => {
        selectedCurrency = document.getElementById("currencySelect").value;
        showPassOptions(vehicleType);
    });
};

//helper methods to showpasses
const selectPlan = (planType, price) => {
    document.getElementById("finalPrice").innerHTML = `
    You selected <strong>${planType}</strong> plan.<br>
    Final Price: <strong>${price} ${selectedCurrency}</strong>
  `;
};