interface RegistrationData {
    name?: string;
    gender?: string;
    email?: string;
    password?: string;
    contact?: string;
    employeeId?: string;
    vehicleBrand?: string;
    vehicleType?: keyof typeof RegistrationForm.prototype.prices;
    vehicleNumber?: string;
}

/**
 * class having methods for all the possible cases to take all the input values
 */
class RegistrationForm {
    private step: number = 0;
    private data: RegistrationData = {};
    private selectedCurrency: keyof typeof this.currencyRates = 'INR';

    public prices = {
        Cycle: [5, 100, 500],
        Motorcycle: [10, 200, 1000],
        Car: [20, 500, 3500]
    };

    private currencyRates = {
        INR: 1,
        USD: 0.012,
        YEN: 1.68
    };

    private formLabel: HTMLLabelElement;
    private formInput: HTMLInputElement;
    private radioContainer: HTMLDivElement;
    private success: HTMLDivElement;
    private formCon: HTMLDivElement;
    private heading3: HTMLHeadingElement;

    /**
     * constructor to take input of all required elements fron dom
     */
    constructor() {
        this.formLabel = document.getElementById('formLabel') as HTMLLabelElement;
        this.formInput = document.getElementById('formInput') as HTMLInputElement;
        this.radioContainer = document.getElementById('radioContainer') as HTMLDivElement;
        this.success = document.getElementById('success') as HTMLDivElement;
        this.heading3 = document.getElementById('form_head') as HTMLHeadingElement;
        this.formCon = document.getElementById('formContainer') as HTMLDivElement;

        const nextButton = document.getElementById('nextBtn');
        if (nextButton) {
            nextButton.addEventListener('click', () => this.handleNext());
        }

        (window as any).selectPlan = this.selectPlan.bind(this);
    }

    handleNext(): void {
        const value = this.formInput.value.trim();
        let proceed = false;

        switch (this.step) {
            case 0: proceed = this.handleNameInput(value); break;
            case 1: proceed = this.handleGenderInput(); break;
            case 2: proceed = this.handleEmailInput(value); break;
            case 3: proceed = this.handlePasswordInput(value); break;
            case 4: proceed = this.handleConfirmPasswordInput(value); break;
            case 5: proceed = this.handleContactInput(value); break;
            case 6: proceed = this.handleRegistrationId(); break;
            case 7: proceed = this.handleVehicleBrandInput(value); break;
            case 8: proceed = this.handleVehicleTypeSelection(); break;
            case 9: proceed = this.handleVehicleNumberInput(value); break;
            case 10: proceed = this.showVehicleInfo(); break;
        }

        if (proceed) this.step++;
    }

    /**
     * method to take input of employee name
     * @param value 
     * @returns true
     */
    private handleNameInput(value: string): boolean {
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

    /**
     * method to take input of employee gender
     * @returns true
     */
    private handleGenderInput(): boolean {
        const selectedGender = document.querySelector('input[name="gender"]:checked') as HTMLInputElement;
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

    /**
     * method to take input of employee email
     * @param value 
     * @returns true
     */
    private handleEmailInput(value: string): boolean {
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

    /**
     * method to take input of employee password
     * @param value 
     * @returns true
     */
    private handlePasswordInput(value: string): boolean {
        if (!this.isPasswordValid(value)) {
            alert("Password must be 8+ characters with upper, lower, number, and special char.");
            return false;
        }
        this.data.password = value;
        this.formLabel.textContent = "Confirm your password";
        this.formInput.value = '';
        return true;
    }

    /**
     * method to take input of employee confirm password
     * @param value 
     * @returns true
     */
    private handleConfirmPasswordInput(value: string): boolean {
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

    /**
     * method to take input of employee contact
     * @param value 
     * @returns true
     */
    private handleContactInput(value: string): boolean {
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

    /**
     * printing the registration number of employee
     * @returns true
     */
    private handleRegistrationId() {
        this.success.style.display = 'none';
        this.formLabel.textContent = "Enter your vehicle brand";
        this.formInput.type = 'text';
        this.formInput.value = '';
        return true;
    }

    /**
     * method to take input of vehicle brand name
     * @param value 
     * @returns true
     */
    private handleVehicleBrandInput(value: string): boolean {
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

    /**
     * method to take input of vehicle type
     * @returns true
     */
    private handleVehicleTypeSelection(): boolean {
        const selectedType = document.querySelector('input[name="type"]:checked') as HTMLInputElement;
        if (!selectedType) {
            alert("Please select your vehicle type.");
            return false;
        }
        this.formCon.style.minHeight = '60vh';
        this.data.vehicleType = selectedType.value as keyof typeof this.prices;
        this.formLabel.textContent = "Enter your vehicle number";
        this.radioContainer.style.display = 'none';
        this.formInput.style.display = 'block';
        this.formInput.value = '';
        return true;
    }

    /**
     * method to take input of vehiclenumber
     * @param value 
     * @returns true
     */
    private handleVehicleNumberInput(value: string): boolean {
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

    /**
     * 
     * @returns printing the vehicle info and showing the passes on basis of vehicle type choosen
     */
    private showVehicleInfo(): boolean {
        const passOptionsContainer = document.getElementById('passOptionsContainer') as HTMLDivElement;
        const [daily, monthly, yearly] = this.prices[this.data.vehicleType!];
        const converted = [daily, monthly, yearly].map(
            (p) => (p * this.currencyRates[this.selectedCurrency]).toFixed(2)
        );

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

        document.getElementById('currencySelect')?.addEventListener('change', () => {
            this.selectedCurrency = (document.getElementById('currencySelect') as HTMLSelectElement).value as keyof typeof this.currencyRates;
            this.showVehicleInfo();
        });

        return true;
    }

    private selectPlan(planType: string, price: string): void {
        document.getElementById('finalPrice')!.innerHTML = `
            You selected <strong>${planType}</strong> plan.<br>
            Final Price: <strong>${price} ${this.selectedCurrency}</strong>
        `;
    }


    // Helper methods to check validity of password and for changing its border color
    private isPasswordValid(pwd: string): boolean {
        return pwd.length >= 8 && /[A-Z]/.test(pwd) && /[a-z]/.test(pwd) && /\d/.test(pwd) && /[^A-Za-z0-9]/.test(pwd);
    }

    private handleInput = (e: Event): void => {
        const strength = this.checkPasswordStrength((e.target as HTMLInputElement).value);
        this.setPasswordBorder(strength);
    }

    private checkPasswordStrength(pwd: string): string {
        let score = 0;
        if (/[A-Z]/.test(pwd)) score++;
        if (/[a-z]/.test(pwd)) score++;
        if (/\d/.test(pwd)) score++;
        if (/[^A-Za-z0-9]/.test(pwd)) score++;
        return score < 2 ? 'weak' : score === 4 ? 'strong' : 'normal';
    }

    private setPasswordBorder(strength: string): void {
        const colors: { [key: string]: string } = {
            weak: '3px solid red',
            normal: '3px solid orange',
            strong: '3px solid green'
        };
        this.formInput.style.border = colors[strength];
    }
}

const registrationForm = new RegistrationForm();

