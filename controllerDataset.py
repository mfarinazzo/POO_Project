import torch
import csv

def generate_dataset( num_samples, mean, std, outliers_ratio):
        # Gera exemplos com a distribuição normal
        normal_samples = torch.randn(num_samples, 1) * std + mean
        normal_labels = torch.ones(num_samples, 1)

        # Gera os outliers
        num_outliers = int(num_samples * outliers_ratio)
        outlier_samples = torch.randn(num_outliers, 1) * std + mean + 3 * std
        outlier_labels = torch.zeros(num_outliers, 1)

        # concatena ambos
        samples = torch.cat((normal_samples, outlier_samples), dim=0)
        labels = torch.cat((normal_labels, outlier_labels), dim=0)

        return samples, labels

def generate_csv( samples, labels, filename):
    with open(filename, 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['valor', 'label'])
        for i in range(len(samples)):
            writer.writerow([float(samples[i][0]), int(labels[i][0])])