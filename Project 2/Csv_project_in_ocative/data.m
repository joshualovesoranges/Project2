function [y] = data()
  y = zeros(1, 1001); % Preallocate array for 1000 points

  for x = 0:1000
      result = x^2 + x;   % Compute x
      y(x+1) = result; % Store result in array
  end
end




