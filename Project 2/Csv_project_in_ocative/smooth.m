function [smoothed_y] = smooth(salted_y)
  windowValue = 50; % the window value
  n = length(salted_y); % the legnth of salted_y
  smoothed_y = zeros(1,n);

  for i = 1:n
    % makes sure index stays in bounds of the array
    preIndex = max(1, i - windowValue);
    nextIndex = min(n, i + windowValue - 1);

    %gets the mean for previous numbers and next numbers according to the window value
    preNums = mean(salted_y(preIndex:i));
    nextNums = mean(salted_y(i:nextIndex));

    smoothed_y(i) = (preNums + nextNums) / 2;
  end
end

