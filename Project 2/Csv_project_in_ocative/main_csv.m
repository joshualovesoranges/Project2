function main_csv()
  % Generate y using the data function
  y = data();

  % Add salt (random noise) to y
  salted_y = salt(y);

  % Smooth the noise
  smoothed_y = smooth(salted_y);

  % Plot Original y
  figure;
  plot(0:1000, y);
  xlabel('Index');
  ylabel('Value');
  title('Original y');
  grid on;

  % Plot Salted y
  figure;
  plot(0:1000, salted_y);
  xlabel('Index');
  ylabel('Value');
  title('Salted y');
  grid on;

  % Plot Smoothed y
  figure;
  plot(0:1000, smoothed_y);
  xlabel('Index');
  ylabel('Value');
  title('Smoothed y');
  grid on;
end

