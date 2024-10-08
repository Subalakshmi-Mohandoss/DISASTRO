import React, { useState } from "react";
import "./App.css";
import Navbar from "./Navbar";
import "./Payment.css";

function Payment() {
  const [amount, setAmount] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate the amount input
    if (amount === "" || isNaN(amount) || Number(amount) <= 0) {
      alert("Please enter a valid amount");
      return;
    }

    setLoading(true);

    const options = {
      key: "rzp_test_Z8NhcNFCL1AhqV", // Your Razorpay Key ID
      amount: amount * 100, // Amount in paise (Razorpay works in paise)
      currency: "INR",
      name: "DISASTRO",
      description: "For donation purpose",
      handler: function (response) {
        alert("Payment ID: " + response.razorpay_payment_id);
        setLoading(false); // Reset button state after successful payment
      },
      prefill: {
        name: "Varsha SR",
        email: "varshasr005@gmail.com",
        contact: "9344681880",
      },
      notes: {
        address: "Razorpay Corporate Office",
      },
      theme: {
        color: "#3399cc",
      },
      modal: {
        ondismiss: function () {
          setLoading(false); // Reset button state if payment is canceled
        },
      },
    };

    // Initialize and open Razorpay payment gateway
    const pay = new window.Razorpay(options);
    pay.open();
  };

  return (
    <div>
      <Navbar />
      <div className="background-container">
        <div className="payment-container">
          <h2>DISASTRO DONATION</h2>
          <p>Make a donation to help those in need.</p>
          <br />
          <br />
          <input
            type="number" // Numeric input for amount
            placeholder="Enter the amount in Rs."
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            className="donation-input" // Class for CSS styling
          />
          <br />
          <br />
          <button
            onClick={handleSubmit}
            disabled={loading}
            className="donate-button"
          >
            {loading ? "Processing..." : "Donate"}
          </button>
        </div>
      </div>
    </div>
  );
}

export default Payment;
