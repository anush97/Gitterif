# Gitterif - GitHub Issue Classifier

Gitterif is a GitHub Issue Classifier that uses machine learning to automatically categorize and label issues in your GitHub repositories. The goal is to save time and improve issue management by automatically predicting the most appropriate labels for each issue.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Training Your Model](#training-your-model)
- [Contributing](#contributing)
- [License](#license)

## Features
- Automatically label GitHub issues based on their content.
- Train custom classification models using your own data.
- Easy integration with GitHub using GitHub Actions.

## Installation

1. Clone the repository:
2. Install the required dependencies:
pip install -r requirements.txt


## Usage

1. Fork the Gitterif repository to your own GitHub account.
2. Set up a GitHub Action to use Gitterif whenever a new issue is created:
- Create a new `.github/workflows/issue_classifier.yml` file in your target repository.
- Copy and paste the following content into the `issue_classifier.yml` file:
```yaml
name: Gitterif Issue Classifier

on:
  issues:
    types: [opened]

jobs:
  classify_issue:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Gitterif
        uses: actions/checkout@v2
        with:
          repository: your-github-username/Gitterif
          ref: main

      - name: Set up Python
        uses: actions/setup-python@v2
        with:
          python-version: 3.x

      - name: Install dependencies
        run: |
          pip install -r requirements.txt

      - name: Classify issue
        run: python gitterif.py --token ${{ secrets.GITHUB_TOKEN }} --owner ${{ github.event.repository.owner.login }} --repo ${{ github.event.repository.name }} --issue ${{ github.event.issue.number }}```
        
3.Replace your-github-username with your own GitHub username.

4.Push the changes to your target repository, and Gitterif will start automatically labeling new issues.

##Training Your Model

1. Prepare your training data in the following format:
issue_title_1, issue_body_1, label_1
issue_title_2, issue_body_2, label_2
...

Save the file as training_data.csv.

2. Train your model using the training data:
`python train_model.py --data training_data.csv --model model.pkl`

3.Replace the model.pkl file in the Gitterif repository with your newly trained model.
