"use strict";
class RegistrationForm {
    constructor() {
        this.step = 0;
        this.data = {};
        this.selectedCurrency = 'INR';
        this.prices = {
            Cycle: [5, 100, 500],
            Motorcycle: [10, 200, 1000],
            Car: [20, 500, 3500]
        };
        this.currencyRates = {
            INR: 1,
            USD: 0.012,
            YEN: 1.68
        };
        this.handleInput = (e) => {
            const strength = this.checkPasswordStrength(e.target.value);
            this.setPasswordBorder(strength);
        };
        this.formLabel = document.getElementById('formLabel');
        this.formInput = document.getElementById('formInput');
        this.radioContainer = document.getElementById('radioContainer');
        this.success = document.getElementById('success');
        this.heading3 = document.getElementById('form_head');
        this.formCon = document.getElementById('formContainer');
        const nextButton = document.getElementById('nextBtn');
        if (nextButton) {
            nextButton.addEventListener('click', () => this.handleNext());
        }
        window.selectPlan = this.selectPlan.bind(this);
    }
    handleNext() {
        const value = this.formInput.value.trim();
        let proceed = false;
        switch (this.step) {
            case 0:
                proceed = this.handleNameInput(value);
                break;
            case 1:
                proceed = this.handleGenderInput();
                break;
            case 2:
                proceed = this.handleEmailInput(value);
                break;
            case 3:
                proceed = this.handlePasswordInput(value);
                break;
            case 4:
                proceed = this.handleConfirmPasswordInput(value);
                break;
            case 5:
                proceed = this.handleContactInput(value);
                break;
            case 6:
                proceed = this.handleRegistrationId();
                break;
            case 7:
                proceed = this.handleVehicleBrandInput(value);
                break;
            case 8:
                proceed = this.handleVehicleTypeSelection();
                break;
            case 9:
                proceed = this.handleVehicleNumberInput(value);
                break;
            case 10:
                proceed = this.showVehicleInfo();
                break;
        }
        if (proceed)
            this.step++;
    }
    handleNameInput(value) {
        if (value.length < 2 || !/^[a-zA-Z ]+$/.test(value)) {
            alert("Please enter a valid full name.");
            return false;
        }
        this.data.name = value;
        this.formLabel.textContent = `Hi ${value}! Can I know your gender?`;
        this.formInput.style.display = 'none';
        this.radioContainer.style.display = 'block';
        return true;
    }
    handleGenderInput() {
        const selectedGender = document.querySelector('input[name="gender"]:checked');
        if (!selectedGender) {
            alert("Please select your gender.");
            return false;
        }
        this.data.gender = selectedGender.value;
        this.radioContainer.style.display = 'none';
        this.formLabel.textContent = "Enter your email";
        this.formInput.type = 'email';
        this.formInput.value = '';
        this.formInput.style.display = 'block';
        return true;
    }
    handleEmailInput(value) {
        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value)) {
            alert("Please enter a valid email.");
            return false;
        }
        this.data.email = value;
        this.formLabel.textContent = "Create a password";
        this.formInput.type = 'password';
        this.formInput.value = '';
        this.formInput.removeEventListener('input', this.handleInput);
        this.formInput.addEventListener('input', this.handleInput);
        return true;
    }
    handlePasswordInput(value) {
        if (!this.isPasswordValid(value)) {
            alert("Password must be 8+ characters with upper, lower, number, and special char.");
            return false;
        }
        this.data.password = value;
        this.formLabel.textContent = "Confirm your password";
        this.formInput.value = '';
        return true;
    }
    handleConfirmPasswordInput(value) {
        if (value !== this.data.password) {
            alert("Passwords do not match.");
            return false;
        }
        this.formInput.removeEventListener('input', this.handleInput);
        this.formInput.style.border = 'none';
        this.formLabel.textContent = "Enter your contact number";
        this.formInput.type = 'tel';
        this.formInput.value = '';
        return true;
    }
    handleContactInput(value) {
        if (!/^\d{10,11}$/.test(value)) {
            alert("Enter a valid contact number.");
            return false;
        }
        this.data.contact = value;
        this.data.employeeId = `EMP${Math.floor(1000 + Math.random() * 9000)}`;
        this.success.innerHTML = `
            Employee Registered Successfully!<br>
            Your Employee ID: <strong>${this.data.employeeId}</strong>
        `;
        this.success.style.display = 'block';
        this.heading3.textContent = "Vehicle Details";
        return true;
    }
    handleRegistrationId() {
        this.success.style.display = 'none';
        this.formLabel.textContent = "Enter your vehicle brand";
        this.formInput.type = 'text';
        this.formInput.value = '';
        return true;
    }
    handleVehicleBrandInput(value) {
        if (value.length < 2 || !/^[a-zA-Z ]+$/.test(value)) {
            alert("Please enter a valid vehicle brand.");
            return false;
        }
        this.data.vehicleBrand = value;
        this.formInput.style.display = 'none';
        this.formCon.style.minHeight = '90vh';
        this.formLabel.textContent = "Select your vehicle type";
        this.radioContainer.innerHTML = `
            <label><input type="radio" name="type" value="Cycle"> Cycle</label>
            <label><input type="radio" name="type" value="Motorcycle"> Motorcycle</label>
            <label><input type="radio" name="type" value="Car"> Car</label>
        `;
        this.radioContainer.style.display = 'block';
        return true;
    }
    handleVehicleTypeSelection() {
        const selectedType = document.querySelector('input[name="type"]:checked');
        if (!selectedType) {
            alert("Please select your vehicle type.");
            return false;
        }
        this.formCon.style.minHeight = '60vh';
        this.data.vehicleType = selectedType.value;
        this.formLabel.textContent = "Enter your vehicle number";
        this.radioContainer.style.display = 'none';
        this.formInput.style.display = 'block';
        this.formInput.value = '';
        return true;
    }
    handleVehicleNumberInput(value) {
        if (!value) {
            alert("Please enter your vehicle number.");
            return false;
        }
        this.data.vehicleNumber = value;
        this.success.innerHTML = `
        Vehicle Registered Successfully!<br>
        Employee ID: <strong>${this.data.employeeId}</strong><br>
        Vehicle Type: <strong>${this.data.vehicleType}</strong><br>
        Vehicle Brand: <strong>${this.data.vehicleBrand}</strong><br>
        Vehicle Number: <strong>${this.data.vehicleNumber}</strong>
      `;
        this.success.style.display = 'block';
        return true;
    }
    showVehicleInfo() {
        var _a;
        const passOptionsContainer = document.getElementById('passOptionsContainer');
        const [daily, monthly, yearly] = this.prices[this.data.vehicleType];
        const converted = [daily, monthly, yearly].map((p) => (p * this.currencyRates[this.selectedCurrency]).toFixed(2));
        passOptionsContainer.innerHTML = `
    <h2 style="text-align:center; font-size:25px;">Choose a ${this.data.vehicleType} Pass</h2>
    <div style="text-align:center; margin: 10px;">
      <label style="font-size:20px">Choose Currency: </label>
      <select style="width:100px;height:30px" id="currencySelect">
        ${Object.keys(this.currencyRates).map(cur => `
          <option value="${cur}"${this.selectedCurrency === cur ? ' selected' : ''}>${cur}</option>
        `).join('')}
      </select>
    </div>
    <div class="pricing">
      ${['Daily', 'Monthly', 'Yearly'].map((type, i) => `
        <div class="vehicle_price">
          <h3>${type}</h3>
          <div class="circle">
            <p class="price">${converted[i]} ${this.selectedCurrency}</p>
          </div>
          <button class="purchase_button" onclick="selectPlan('${type}', ${converted[i]})">Get Pass</button>
        </div>
      `).join('')}
    </div>
    <div id="finalPrice"></div>
  `;
        (_a = document.getElementById('currencySelect')) === null || _a === void 0 ? void 0 : _a.addEventListener('change', () => {
            this.selectedCurrency = document.getElementById('currencySelect').value;
            this.showVehicleInfo();
        });
        return true;
    }
    selectPlan(planType, price) {
        document.getElementById('finalPrice').innerHTML = `
            You selected <strong>${planType}</strong> plan.<br>
            Final Price: <strong>${price} ${this.selectedCurrency}</strong>
        `;
    }
    isPasswordValid(pwd) {
        return pwd.length >= 8 && /[A-Z]/.test(pwd) && /[a-z]/.test(pwd) && /\d/.test(pwd) && /[^A-Za-z0-9]/.test(pwd);
    }
    checkPasswordStrength(pwd) {
        let score = 0;
        if (/[A-Z]/.test(pwd))
            score++;
        if (/[a-z]/.test(pwd))
            score++;
        if (/\d/.test(pwd))
            score++;
        if (/[^A-Za-z0-9]/.test(pwd))
            score++;
        return score < 2 ? 'weak' : score === 4 ? 'strong' : 'normal';
    }
    setPasswordBorder(strength) {
        const colors = {
            weak: '3px solid red',
            normal: '3px solid orange',
            strong: '3px solid green'
        };
        this.formInput.style.border = colors[strength];
    }
}
const registrationForm = new RegistrationForm();
