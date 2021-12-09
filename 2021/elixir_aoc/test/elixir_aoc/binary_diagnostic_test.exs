defmodule ElixirAoc.BinaryDiagnosticsTest do
  use ExUnit.Case, async: true
  doctest ElixirAoc.BinaryDiagnostics
  alias ElixirAoc.BinaryDiagnostics

  test "with sample input" do
    sample = [
      [0, 0, 1, 0, 0],
      [1, 1, 1, 1, 0],
      [1, 0, 1, 1, 0],
      [1, 0, 1, 1, 1],
      [1, 0, 1, 0, 1],
      [0, 1, 1, 1, 1],
      [0, 0, 1, 1, 1],
      [1, 1, 1, 0, 0],
      [1, 0, 0, 0, 0],
      [1, 1, 0, 0, 1],
      [0, 0, 0, 1, 0],
      [0, 1, 0, 1, 0]
    ]

    assert BinaryDiagnostics.power_consumption(sample) == 198
  end

  test "transpose/1 - transpose matrix" do
    sample = [
      [1, 1, 1],
      [0, 0, 0]
    ]

    assert BinaryDiagnostics.tranpose(sample) |> Enum.into([]) == [
             [1, 0],
             [1, 0],
             [1, 0]
           ]
  end

  test "parse_input/1 - parses string to matrix of integers" do
    sample = """
    00100
    11110
    10110
    10111
    10101
    01111
    00111
    11100
    10000
    11001
    00010
    01010
    """

    assert BinaryDiagnostics.parse_input!(sample) == [
             [0, 0, 1, 0, 0],
             [1, 1, 1, 1, 0],
             [1, 0, 1, 1, 0],
             [1, 0, 1, 1, 1],
             [1, 0, 1, 0, 1],
             [0, 1, 1, 1, 1],
             [0, 0, 1, 1, 1],
             [1, 1, 1, 0, 0],
             [1, 0, 0, 0, 0],
             [1, 1, 0, 0, 1],
             [0, 0, 0, 1, 0],
             [0, 1, 0, 1, 0]
           ]
  end

  test "run for sample input" do
    result =
      "sample-input/day3-part1.txt"
      |> BinaryDiagnostics.parse_file!()
      |> BinaryDiagnostics.power_consumption()

    assert result == 3_277_364
  end
end
